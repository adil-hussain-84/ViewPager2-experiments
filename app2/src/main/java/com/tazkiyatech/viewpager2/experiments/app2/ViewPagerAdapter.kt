package com.tazkiyatech.viewpager2.experiments.app2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private var counter = 0L
    private var itemIds: List<Long>

    init {
        itemIds = generateListOfItemIds()

        val adapterDataObserver = object : AdapterDataObserver() {

            override fun onChanged() {
                itemIds = generateListOfItemIds()
            }
        }

        registerAdapterDataObserver(adapterDataObserver)
    }

    private fun generateListOfItemIds() = (1..5).map { counter++ }

    override fun createFragment(position: Int): Fragment {
        return PageFragment.newInstance(position + 1)
    }

    override fun getItemCount(): Int {
        return itemIds.size
    }

    override fun getItemId(position: Int): Long {
        return itemIds[position]
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemIds.contains(itemId)
    }
}