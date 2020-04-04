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
import kotlinx.android.synthetic.main.student_instruction_fragment.*

class NeedyInstructionFragment : Fragment()
{

    lateinit var context: FragmentActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.student_instruction_fragment, container, false)
    }


    override fun onAttach(activity: Activity) {
        context = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fragmentManager: FragmentManager =  context.supportFragmentManager
        val registerFragment = RegisterFragment()



        student_instruc_search_button.setOnClickListener{

                fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
                    .replace(R.id.containerForFragment, searchFragment).commit()

        }

    }


}