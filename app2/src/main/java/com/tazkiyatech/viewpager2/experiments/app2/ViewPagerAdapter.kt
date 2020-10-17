package com.tazkiyatech.viewpager2.experiments.app2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private var currentOffset = 0L
    private var nextOffset = itemCount.toLong()

    init {
        val adapterDataObserver = object : AdapterDataObserver() {

            override fun onChanged() {
                super.onChanged()
                currentOffset = nextOffset
                nextOffset += itemCount
            }
        }

        registerAdapterDataObserver(adapterDataObserver)
    }

    override fun createFragment(position: Int): Fragment {
        return PageFragment.newInstance(position + 1)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun getItemId(position: Int): Long {
        return currentOffset + position
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemId >= currentOffset && itemId < (currentOffset + itemCount)
    }
}