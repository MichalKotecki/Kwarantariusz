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
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.idea.xxx.kwarantariusz.Data.OrderItemData


class RegisterFragment : NavHostFragment() {

    lateinit var context: FragmentActivity
    lateinit var queue: RequestQueue

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


        register_button.setOnClickListener{


            if (phone_register.text.isEmpty())
            {
                phone_register.error = getString(R.string.pleaseenterphone)
                phone_register.requestFocus()
            }
            else if (!isPhoneNumberValid())
            {
                phone_register.error = getString(R.string.thisisnotavalidphonenumber)
                phone_register.requestFocus()
            }
            else if (city_register.text.isEmpty())
            {
                city_register.error = getString(R.string.pleaseentercity)
                city_register.requestFocus()
            }
            else if (address_register.text.isEmpty())
            {
                address_register.error = getString(R.string.pleaseenteraddress)
                address_register.requestFocus();
            }
            else if (password_register.text.isEmpty())
            {
                password_register.error = getString(R.string.pleaseenterpassword)
                password_register.requestFocus()
            }
            else if (password_register_repeat.text.isEmpty())
            {
                password_register_repeat.error = getString(R.string.pleaseenterpassword)
                password_register_repeat.requestFocus();
            }
            else if(password_register.text.toString() != password_register_repeat.text.toString()) {

                password_register_repeat.error = getString(R.string.passwordsdonotmatch)
                password_register_repeat.requestFocus()
            }
            else
            {
                Toast.makeText(context, "I can create your account", Toast.LENGTH_SHORT).show()
            }
        }


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

    fun formatPhoneNumber(): String
    {
        var phoneNumber = phone_register.text.toString()
        phoneNumber = phoneNumber.replace("-", "")
        phoneNumber = phoneNumber.replace(" ", "")
        return phoneNumber
    }

    fun isPhoneNumberValid(): Boolean {
        var phoneNumber = formatPhoneNumber()

        Toast.makeText(context, phoneNumber, Toast.LENGTH_SHORT).show()
        if(phoneNumber.length != 9)
        {
            Toast.makeText(context, "Lenght is different than 9", Toast.LENGTH_SHORT).show()
            return false
        }
        phoneNumber.forEach { char -> if(!char.isDigit()){
            Toast.makeText(context, "One of chars is not a digit", Toast.LENGTH_SHORT).show()
            return false} }

        Toast.makeText(context, "Everything in function is OK", Toast.LENGTH_SHORT).show()
        return true
    }


    fun sendRegisterRequest()
    {
        queue = Volley.newRequestQueue(context)
        var URL: String = "https://quaranteerserver.000webhostapp.com/signup.php?phone=%phone%?password=%password%?city=%city%?address=%address%"
        URL = URL.replace("%phone%", phone_register.text.toString())
        URL = URL.replace("%password%", password_register.text.toString())
        URL = URL.replace("%city%", city_register.text.toString())
        URL = URL.replace("%adddress%", address_register.text.toString())

        val stringRequest = StringRequest(
            Request.Method.POST, URL,
            Response.Listener<String> { response ->

            },
            Response.ErrorListener {
                Toast.makeText(context, "ERROR: Unable to connect with server. Check Internet connection.", Toast.LENGTH_SHORT ).show()
            })
        queue.add(stringRequest)
    }
}