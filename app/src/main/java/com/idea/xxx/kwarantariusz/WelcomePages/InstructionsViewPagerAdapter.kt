package com.idea.xxx.kwarantariusz.WelcomePages;


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentManager


class InstructionsViewPageAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val COUNT = 3

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment = Fragment()     //  tu wczesniej byl null
        when (position) {
            0 -> fragment = WelcomePageInstructionFragment()
            1 -> fragment = NeedyInstructionFragment()
            2 -> fragment = QuaranteerInstructionFragment()
        }

        return fragment

    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        //return "Tab " + (position + 1)
        return ""
    }
}
