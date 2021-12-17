package com.tazkiyatech.viewpager2.experiments.app3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentManager = fragmentActivity.supportFragmentManager

    init {
        val adapterDataObserver = object : RecyclerView.AdapterDataObserver() {

            override fun onChanged() {
                (0 until itemCount).forEach { getFragment(it)?.refreshHelloWorldMessage() }
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

    private fun getFragment(position: Int): PageFragment? {
        val itemId = getItemId(position)
        return fragmentManager.findFragmentByTag("f$itemId") as? PageFragment
    }
}