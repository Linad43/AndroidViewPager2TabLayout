package com.example.androidviewpager2tablayout

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class WebPageAdapter(
    fragment: FragmentActivity,
    private val list: ArrayList<MyWebsite>
    ):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ViewPagerFragment()
        fragment.arguments = bundleOf("web" to list[position])
        return fragment
    }
}