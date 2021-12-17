# FragmentStateAdapter.notifyDataSetChanged() simple workaround

This Android application demonstrates a workaround for the bug wherein calling
the `FragmentStateAdapter.notifyDataSetChanged()` method does not result in
a [ViewPager2](https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2) recreating
its `Fragment`s (see [app1](../app1) for a demonstration of the bug).

The bug appears to be because the default implementation of
the [FragmentStateAdapter.getItemId(position:)](https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter#getItemId(int))
method is to simply return the `position` passed into it. The `itemId` for each `position` is therefore the
same before and after the `FragmentStateAdapter.notifyDataSetChanged()` call and therefore none of
the `Fragment`s will be recreated.

The workaround is to modify
the [FragmentStateAdapter](https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter)
implementation in a threefold manner as follows:

1. Introduce an `itemIds` property;
2. Override the `getItemId(position:)` and `containsItem(itemId:)` methods to key off the new `itemIds`
   property;
3. Regenerate the values in the `itemIds` property on each call to `notifyDataSetChanged()`.

See the [ViewPagerAdapter](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/ViewPagerAdapter.kt)
class for a concrete implementation of this logic. Further, see
the [MainActivity.onCreate(savedInstanceState:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/MainActivity.kt)
method for the place where
the [ViewPagerAdapter](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/ViewPagerAdapter.kt) is
associated to the [ViewPager2](https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2)
in the application and see
the [MainActivity.onOptionsItemSelected(item:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app2/MainActivity.kt)
method for the place where `FragmentStateAdapter.notifyDataSetChanged()` is called.
