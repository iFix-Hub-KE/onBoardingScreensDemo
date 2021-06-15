package com.kanyideveloper.onboardingscreensdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabsAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitles = ArrayList<String>()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }

    fun addFragments(fragment: Fragment, fragmentTitle: String){
        fragmentList.add(fragment)
        fragmentTitles.add(fragmentTitle)
    }
}