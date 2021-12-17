# FragmentStateAdapter.notifyDataSetChanged() alternative workaround

The [app1](../app1) module in this project demonstrates that the default implementation of
the `getItemId(position:)` and `containsItem(itemId:)` methods in
the [FragmentStateAdapter](https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter)
class result in the `Fragment`s in
the [FragmentStateAdapter](https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter)
remaining unchanged when the `FragmentStateAdapter.notifyDataSetChanged()` method is called.
The [app2](../app2) module in this project demonstrates the proper workaround for this issue. This Android
application demonstrates an alternative workaround wherein the `Fragment`s in
the [FragmentStateAdapter](https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter)
are not recreated but instead receive a method invocation to update themselves.

See the [ViewPagerAdapter](src/main/java/com/tazkiyatech/viewpager2/experiments/app3/ViewPagerAdapter.kt)
class for the place where the `FragmentStateAdapter.notifyDataSetChanged()` call is picked up and passed on to
the `Fragment`s. See
the [MainActivity.onCreate(savedInstanceState:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app3/MainActivity.kt)
method for the place where
the [ViewPagerAdapter](src/main/java/com/tazkiyatech/viewpager2/experiments/app3/ViewPagerAdapter.kt) is
associated to the [ViewPager2](https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2)
in the application. See
the [MainActivity.onOptionsItemSelected(item:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app3/MainActivity.kt)
method for the place where `FragmentStateAdapter.notifyDataSetChanged()` is called.