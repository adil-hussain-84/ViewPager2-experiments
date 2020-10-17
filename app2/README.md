# FragmentStateAdapter.notifyDataSetChanged() simple workaround

This Android application demonstrates a workaround for the bug wherein calling the `FragmentStateAdapter.notifyDataSetChanged()` method does not result in a `ViewPager2` recreating its `Fragment`s (see [app1](../app1) for a demonstration of the bug).

The bug appears to be because the default implementation of the `FragmentStateAdapter.getItemId(position:)` method is to simply return the `position` passed into it.
The `itemId` for each `position` will therefore be the same before and after the `FragmentStateAdapter.notifyDataSetChanged()` call and therefore none of the `Fragment`s will be recreated.

The workaround is to introduce an offset which adjusts the `itemId` values after each call to `notifyDataSetChanged()` and thus forces a recreation of the fragments.
See the `init` block in the [ViewPagerAdapter](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/ViewPagerAdapter.kt) class which facilitates this workaround;
an `AdapterDataObserver` is registered in this block which receives a callback whenever `notifyDataSetChanged()` is called.

See the [MainActivity.onCreate(savedInstanceState:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/MainActivity.kt) method for the place where the `ViewPagerAdapter` is associated to the `ViewPager2` in the application and see the [MainActivity.onOptionsItemSelected(item:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/MainActivity.kt) method for the place where `FragmentStateAdapter.notifyDataSetChanged()` is called.
