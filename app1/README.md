# FragmentStateAdapter.notifyDataSetChanged() bug

This Android application demonstrates that calling the `FragmentStateAdapter.notifyDataSetChanged()` method on
a [FragmentStateAdapter](https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter)
which is associated to
a [ViewPager2](https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2) does not result
in the [ViewPager2](https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2) recreating
its `Fragment`s.
The [Modifiable fragment collections](https://developer.android.com/training/animation/vp2-migration#modifiable-fragments)
section in
the [Migrate from ViewPager to ViewPager2](https://developer.android.com/training/animation/vp2-migration)
page seems to imply that the UI should be updated, as follows:

> `ViewPager2` supports paging through a modifiable collection of fragments, calling `notifyDatasetChanged()` to update the UI when the underlying collection changes.
>
> This means that your app can dynamically modify the fragment collection at runtime, and `ViewPager2` will correctly display the modified collection.

The [FragmentStateAdapter](https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter)
implementation in this application
(i.e. [ViewPagerAdapter](src/main/java/com/tazkiyatech/viewpager2/experiments/app1/ViewPagerAdapter.kt)) is
absolutely minimal such that only the `createFragment(position:)` and `getItemCount()` methods are overridden.
See
the [MainActivity.onCreate(savedInstanceState:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app1/MainActivity.kt)
method for the place where
the [FragmentStateAdapter](https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter)
is associated to the `ViewPager2`. See
the [MainActivity.onOptionsItemSelected(item:)](src/main/java/com/tazkiyatech/viewpager2/experiments/app1/MainActivity.kt)
method for the place where `FragmentStateAdapter.notifyDataSetChanged()` is called.

#### Links

* See [here](https://issuetracker.google.com/issues/171039652) for the associated bug report in IssueTracker.
* See the [app2](../app2) module in this project for a workaround.
