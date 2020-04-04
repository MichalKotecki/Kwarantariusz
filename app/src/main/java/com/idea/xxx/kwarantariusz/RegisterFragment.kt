package com.idea.xxx.kwarantariusz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.register_fragment.*
import android.app.Activity
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RegisterFragment : NavHostFragment() {

    lateinit var context: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onAttach(activity: Activity) {
        context = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.register)  // This line changes the title in the top bar

        val fragmentManager: FragmentManager = context.supportFragmentManager
        val loginFragment = LoginFragment()


        textGoLogin.setOnClickListener { view ->

            fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
                .replace(R.id.containerForFragment, loginFragment)
                .commit()
            //view.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.toRegex().matches(email)
    }
}