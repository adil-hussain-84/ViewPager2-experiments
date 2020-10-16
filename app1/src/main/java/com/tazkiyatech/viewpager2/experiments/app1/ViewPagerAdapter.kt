package com.tazkiyatech.viewpager2.experiments.app1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    override fun createFragment(position: Int): Fragment {
        return PageFragment.newInstance(position + 1)
    }

    override fun getItemCount(): Int {
        return 5
    }
}