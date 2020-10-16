# FragmentStateAdapter.notifyDataSetChanged() bug

This Android application demonstrates that calling the `FragmentStateAdapter.notifyDataSetChanged()` method on a `FragmentStateAdapter` which is associated to a `ViewPager2` does not result in the `ViewPager2` recreating its `Fragment`s.
The [Modifiable fragment collections](https://developer.android.com/training/animation/vp2-migration#modifiable-fragments) section in the [Migrate from ViewPager to ViewPager2](https://developer.android.com/training/animation/vp2-migration) seems to imply that the UI should be updated, as follows:

> `ViewPager2` supports paging through a modifiable collection of fragments, calling `notifyDatasetChanged()` to update the UI when the underlying collection changes.
>
> This means that your app can dynamically modify the fragment collection at runtime, and `ViewPager2` will correctly display the modified collection.

See the [MainActivity.onCreate(Bundle?)](src/main/java/com/tazkiyatech/viewpager2/experiments/app1/MainActivity.kt) method for the place where the `FragmentStateAdapter` is associated to the `ViewPager2` and the [MainActivity.onOptionsItemSelected(MenuItem)](src/main/java/com/tazkiyatech/viewpager2/experiments/app1/MainActivity.kt) method for the place where `FragmentStateAdapter.notifyDataSetChanged()` is called. You will observe by running or debugging the application that the `Fragment`s in the `ViewPager` are not recreated.