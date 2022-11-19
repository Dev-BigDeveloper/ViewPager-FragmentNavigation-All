package com.example.viewpagerall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerall.R
import com.example.viewpagerall.adapters.PagerFragmentAdapter
import com.example.viewpagerall.databinding.FragmentViewListPagerBinding
import com.example.viewpagerall.databinding.FragmentViewPagerPagerAdapterBinding
import com.example.viewpagerall.fragmentStatePagerService.ZoomOutPageTransformer

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class ViewPagerFragmentPagerAdapterFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var bindingFragment:FragmentViewPagerPagerAdapterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingFragment = FragmentViewPagerPagerAdapterBinding.inflate(inflater,container,false)

        setupViewPager2()
        return bindingFragment.root
    }

    private fun setupViewPager2() {
        val colorList = arrayListOf("#00ff00", "#ff0000", "#0000ff", "#f0f0f0")
        bindingFragment.viewPager.adapter = PagerFragmentAdapter(requireActivity(), colorList)
        bindingFragment.viewPager.setPageTransformer(ZoomOutPageTransformer())
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewPagerFragmentPagerAdapterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}