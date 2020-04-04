package com.idea.xxx.kwarantariusz.WelcomePages

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.idea.xxx.kwarantariusz.R
import com.idea.xxx.kwarantariusz.RegisterFragment
import kotlinx.android.synthetic.main.viewpager_fragment.*

class ViewPagerFragment : Fragment()
{

    lateinit var context: FragmentActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.viewpager_fragment, container, false)
    }


    override fun onAttach(activity: Activity) {
        context = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fragmentManager: FragmentManager =  context.supportFragmentManager
        val registerFragment = RegisterFragment()

        //val viewPager = findViewById<ViewPager>(R.id.viewPager)


        if (viewPager != null) {
            val adapter =
                InstructionsViewPageAdapter(context.supportFragmentManager)
            viewPager.adapter = adapter
            viewpager_bottom_dots.setupWithViewPager(viewPager, true)
        }


    }
}