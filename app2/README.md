# FragmentStateAdapter.notifyDataSetChanged() workaround

This Android application demonstrates a workaround for the bug wherein calling the `FragmentStateAdapter.notifyDataSetChanged()` method does not result in a `ViewPager2` recreating its `Fragment`s (see [app1](../app1)).

The bug appears to be because the default implementation of the `FragmentStateAdapter.getItemId(position:)` method is to simply return the `position` passed into it.
The `itemId` for each `position` will therefore be the same before and after the `FragmentStateAdapter.notifyDataSetChanged()` call and therefore none of the `Fragment`s will be recreated.

The workaround is to introduce an offset which can adjust the `itemId` values and thus forces a recreation of the fragments.
See the [ViewPagerAdapter.reloadPages()](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/ViewPagerAdapter.kt) method which facilitates this workaround. This method has been defined instead of overriding the `FragmentStateAdapter.notifyDataSetChanged()` method because the `FragmentStateAdapter.notifyDataSetChanged()` method is declared as final and thus cannot be overridden.

See the [MainActivity.onCreate(savedInstanceState:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/MainActivity.kt) method for the place where the `ViewPagerAdapter` is associated to the `ViewPager2` in the application and see the [MainActivity.onOptionsItemSelected(item:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/MainActivity.kt) method for the place where `ViewPagerAdapter.reloadPages()` is called.
