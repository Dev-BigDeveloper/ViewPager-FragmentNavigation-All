package com.example.viewpagerall.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.viewpagerall.model.ModelObject

    class ViewListAdapter(private val context: Context) : PagerAdapter() {
    override fun getCount(): Int {
        return ModelObject.values().size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val modelObject = ModelObject.values()[position]
        val inflater = LayoutInflater.from(context)
        val layout:ViewGroup = inflater.inflate(modelObject.layoutResId,container,false) as ViewGroup
        container.addView(layout)
        return layout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getPageTitle(position: Int): CharSequence {
        val customPagerEnum = ModelObject.values()[position]
        return context.getString(customPagerEnum.titleResId)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

}