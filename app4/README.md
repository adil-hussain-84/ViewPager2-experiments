# ViewPager2.offscreenPageLimit bug

This Android application demonstrates that setting the [ViewPager2.offscreenPageLimit](https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2#setOffscreenPageLimit(int)) property to a value which is not the default [OFFSCREEN_PAGE_LIMIT_DEFAULT](https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2#OFFSCREEN_PAGE_LIMIT_DEFAULT) value does not work as expected.
It seems that more pages are created and retained than requested.

The application consists of an `Activity` class ([MainActivity](src/main/java/com/tazkiyatech/viewpager2/experiments/app4/MainActivity.kt)), a `FragmentStateAdapter` implementation ([ViewPagerAdapter](src/main/java/com/tazkiyatech/viewpager2/experiments/app4/ViewPagerAdapter.kt)) and a `Fragment` class ([PageFragment](src/main/java/com/tazkiyatech/viewpager2/experiments/app4/PageFragment.kt)).
The [ViewPager2.offscreenPageLimit](https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2#setOffscreenPageLimit(int)) property is set in [MainActivity](src/main/java/com/tazkiyatech/viewpager2/experiments/app4/MainActivity.kt) to `1` with the intention that only one page is retained  either side of the currently visible page.

When the application is run, the `ViewPager2` instance, which has an item count of ten, is initialised and only pages 1 and 2 are created, as expected. On tapping the second tab, only page 3 is created, as expected. However, on scrolling to a tab further away – e.g. the tenth tab – and tapping on it, pages 6, 7, 8, 9 and 10 are created.
The expectation was that only pages 9 and 10 would be created.

##### Additional links

* See [here](https://issuetracker.google.com/issues/171180138) for the associated bug report in IssueTracker.
