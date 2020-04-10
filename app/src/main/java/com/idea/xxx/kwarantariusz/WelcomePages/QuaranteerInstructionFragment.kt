package com.idea.xxx.kwarantariusz.WelcomePages

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.idea.xxx.kwarantariusz.BlankFragment
import com.idea.xxx.kwarantariusz.R
import com.idea.xxx.kwarantariusz.RegisterFragment
import kotlinx.android.synthetic.main.quaranteer_instruction_fragment.*

class QuaranteerInstructionFragment : Fragment()
{

    lateinit var context: FragmentActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.quaranteer_instruction_fragment, container, false)
    }


    override fun onAttach(activity: Activity) {
        context = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.quaranteer_uppercase)  // This line changes the title in the top bar

        val fragmentManager: FragmentManager =  context.supportFragmentManager
        val registerFragment = RegisterFragment()

        teacher_instructions_visit_website_button.setOnClickListener{

            val sharedPreferences = context.getSharedPreferences("Preferences_User_Data", Context.MODE_PRIVATE)
            val isLogged = sharedPreferences.getBoolean("isLogged", false)
            val blankFragment = BlankFragment()

            teacher_instructions_visit_website_button.setOnClickListener{
                fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
                    .replace(R.id.containerForFragment, blankFragment).commit()
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