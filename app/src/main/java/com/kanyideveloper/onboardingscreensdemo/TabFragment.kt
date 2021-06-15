package com.kanyideveloper.onboardingscreensdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.kanyideveloper.onboardingscreensdemo.databinding.FragmentTabBinding


class TabFragment : Fragment() {

    private lateinit var binding: FragmentTabBinding
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabBinding.inflate(inflater,container,false)
        val view = binding.root

        viewPager = view.findViewById(R.id.viewPagersTabs)


        setupTabs()


        return view
    }

    private fun setupTabs(){
        val adapter = TabsAdapter(activity?.supportFragmentManager!!)
        adapter.addFragments(Screen1(),"Test1")
        adapter.addFragments(Screen2(),"Test2")
        adapter.addFragments(Screen3(),"Test3")

        viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(viewPager)
    }
}