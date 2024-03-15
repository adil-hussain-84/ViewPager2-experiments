package com.tazkiyatech.viewpager2.experiments.app3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val tabLayout: TabLayout
        get() = findViewById(R.id.tabLayout)

    private val viewPager: ViewPager2
        get() = findViewById(R.id.viewPager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(R.string.tab_text_format, position + 1)
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_activity_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.reloadPagesMenuItem -> {
                viewPager.adapter?.notifyDataSetChanged()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
