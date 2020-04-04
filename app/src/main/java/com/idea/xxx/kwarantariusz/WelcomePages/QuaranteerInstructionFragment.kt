package com.idea.xxx.kwarantariusz.WelcomePages

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.idea.xxx.kwarantariusz.R
import com.idea.xxx.kwarantariusz.RegisterFragment
import kotlinx.android.synthetic.main.teacher_instruction_fragment.*

class QuaranteerInstructionFragment : Fragment()
{

    lateinit var context: FragmentActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.teacher_instruction_fragment, container, false)
    }


    override fun onAttach(activity: Activity) {
        context = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fragmentManager: FragmentManager =  context.supportFragmentManager
        val registerFragment = RegisterFragment()
        val addNewAdvertFragment = AddNewAdvertFragment()



        teacher_instructions_visit_website_button.setOnClickListener{

            val sharedPreferences = context.getSharedPreferences("Preferences_User_Data", Context.MODE_PRIVATE)
            val isLogged = sharedPreferences.getBoolean("isLogged", false)
            val joinCommunityFragment: JoinCommunityFragment = JoinCommunityFragment()

            teacher_instructions_visit_website_button.setOnClickListener{
                fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
                    .replace(R.id.containerForFragment, joinCommunityFragment).commit()
            }

//            if(isLogged)
//            {
//                fragmentManager.beginTransaction()
//                    .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
//                    .replace(R.id.containerForFragment, addNewAdvertFragment).commit()
//            }
//            else
//            {
//                fragmentManager.beginTransaction()
//                    .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
//                    .replace(R.id.containerForFragment, registerFragment).commit()
//            }
        }
    }
}