package com.example.myfragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myFragmentimport.Fragment_second

@Suppress("DEPRECATION")
 class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Fragment_first()
            }
            1 -> {
                Fragment_second()
            }

            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}