package com.tazkiyatech.viewpager2.experiments.app2

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.*

class ViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    private var timestamp = Date().time

    override fun createFragment(position: Int): Fragment {
        return PageFragment.newInstance(position + 1)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun getItemId(position: Int): Long {
        return timestamp + position
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemId >= timestamp && itemId < (timestamp + itemCount)
    }

    fun reloadPages() {
        timestamp = Date().time
        notifyDataSetChanged()
    }
}