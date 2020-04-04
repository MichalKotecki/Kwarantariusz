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


        register_button.setOnClickListener {

            if (email_register.text.isEmpty() && password_register.text.isEmpty()) {
                Toast.makeText(context, getString(R.string.fieldsareempty), Toast.LENGTH_SHORT)
                    .show();
            }
            else if (email_register.text.isEmpty()) {
                email_register.error = getString(R.string.pleaseenteremail)
                email_register.requestFocus();
            }
            else if (password_register.text.isEmpty()) {
                password_register.error = getString(R.string.pleaseenterpassword)
                password_register.requestFocus();
            }
            else if(password_register_repeat.text.equals(password_register.text.toString())){
                password_register.error = "Uncorrect repeated password"
                password_register.requestFocus();
            } else {
//                MainActivity.client.registerAccount(
//                    RegisterDto(
//                        email = email_register.text.toString(),
//                        username = nickname.text.toString(),
//                        password = password_register.text.toString(),
//                        typeUser = "student"
//                    )
//                ).enqueue(object : Callback<MessageDto> {
//                    override fun onResponse(
//                        call: Call<MessageDto>,
//                        response: retrofit2.Response<MessageDto>
//                    ) {
//                        if (response.code()==200) {
//                            Toast.makeText(
//                                context,
//                                response.body()!!.message,
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            fragmentManager.beginTransaction()
//                                .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
//                                .replace(R.id.containerForFragment, loginFragment)
//                                .commit()
//                        }else if(response.code()==404) {
//                            Toast.makeText(
//                                context,
//                                "email incorrect",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                        else{
//                               // Toast.makeText( context, response.body()!!.message, Toast.LENGTH_SHORT ).show()
//                            }
//                        }
//                    override fun onFailure(call: Call<MessageDto>, t: Throwable) {
//                        Toast.makeText(
//                            context,
//                            "error",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            )


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
}