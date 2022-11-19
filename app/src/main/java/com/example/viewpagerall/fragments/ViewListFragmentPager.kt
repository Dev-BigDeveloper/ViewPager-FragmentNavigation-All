package com.example.viewpagerall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.viewpagerall.adapters.ViewListAdapter
import com.example.viewpagerall.databinding.FragmentViewListPagerBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViewListFragmentPager : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var bindingFragment:FragmentViewListPagerBinding
    private lateinit var adapter:ViewListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingFragment = FragmentViewListPagerBinding.inflate(inflater,container,false)
        bindingFragment.backInMenu.setOnClickListener {
            findNavController().popBackStack()
        }
        adapter = ViewListAdapter(requireContext())
        bindingFragment.viewpager.adapter = adapter
        return bindingFragment.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewListFragmentPager().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}