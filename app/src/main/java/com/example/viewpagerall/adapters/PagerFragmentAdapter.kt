package com.example.viewpagerall.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagerall.fragments.FragmentItem

class PagerFragmentAdapter(fragmentActivity: FragmentActivity, private var colorList: ArrayList<String>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return colorList.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = FragmentItem()
        val args = Bundle()
        args.putString("color", colorList[position])
        args.putString("label", "Fragment Number: ${position + 1}")
        fragment.arguments = args
        return fragment
    }
}