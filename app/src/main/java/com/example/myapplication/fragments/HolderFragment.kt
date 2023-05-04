package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.adapters.ViewPagerFragmentAdapter
import com.example.myapplication.databinding.FragmentHolderBinding

class HolderFragment: Fragment() {

    private var _binding: FragmentHolderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHolderBinding.inflate(inflater, container, false)

        val fragmentList: ArrayList<Fragment> = arrayListOf(
            FirstFragment(),
            SecondFragment(),
        )

        val adapter = ViewPagerFragmentAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}