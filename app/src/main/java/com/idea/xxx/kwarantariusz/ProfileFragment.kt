package com.idea.xxx.kwarantariusz

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
import kotlinx.android.synthetic.main.profile_fragment.*
import android.widget.CompoundButton



class ProfileFragment : Fragment()
{

    lateinit var context: FragmentActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }


    override fun onAttach(activity: Activity) {
        context = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.profile)  // This line changes the title in the top bar

        val fragmentManager: FragmentManager =  context.supportFragmentManager
        val registerFragment = RegisterFragment()
        val loginFragment = LoginFragment()



        val sharedPreferences = context.getSharedPreferences("Preferences_User_Data", Context.MODE_PRIVATE)

        val username: String? = sharedPreferences.getString("username", "Name")
        name_profile_edit.setText(username)

        val email: String? = sharedPreferences.getString("email", "Email")
        phone_profile_edit.setText(email)

        val city: String? = sharedPreferences.getString("city", "City")
        city_profile_edit.setText(city)

        val street: String? = sharedPreferences.getString("street", "Street")
        address_profile_edit.setText(street)


        edit_profile_switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                name_profile_edit.isEnabled = true
                phone_profile_edit.isEnabled = true
                password_profile_edit.isEnabled = true
                city_profile_edit.isEnabled = true
                address_profile_edit.isEnabled = true
            }
            else
            {
                name_profile_edit.isEnabled = false
                phone_profile_edit.isEnabled = false
                password_profile_edit.isEnabled = false
                city_profile_edit.isEnabled = false
                address_profile_edit.isEnabled = false
            }
        })


        save_profile_button.setOnClickListener {
            // TODO zapisywanie do shared preferences oraz zmianę w bazie danych
        }


        logout_profile_button.setOnClickListener{

            val sharedPreferences = context.getSharedPreferences("Preferences_User_Data", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.putBoolean("isLogged", false)
            editor.apply()
            fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
                .replace(R.id.containerForFragment, loginFragment).commit()
        }

    }
}