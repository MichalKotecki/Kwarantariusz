package com.idea.xxx.kwarantariusz
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.idea.xxx.kwarantariusz.WelcomePages.ViewPagerFragment
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : Fragment() {

    lateinit var context: FragmentActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }


    override fun onAttach(activity: Activity) {
        context = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.login)  // This line changes the title in the top bar

        val fragmentManager: FragmentManager = context.supportFragmentManager
        val registerFragment = RegisterFragment()

        val viewPagerFragment = ViewPagerFragment()
        val profileFragment = ProfileFragment()
        login_button.setOnClickListener {

            if (email_login.text.isEmpty() && password_login.text.isEmpty()) {
                Toast.makeText(context, getString(R.string.fieldsareempty), Toast.LENGTH_SHORT)
                    .show();
            } else if (email_login.text.isEmpty()) {
                email_login.error = getString(R.string.pleaseenteremail)
                email_login.requestFocus();
            } else if (password_login.text.isEmpty()) {
                password_login.error = getString(R.string.pleaseenterpassword)
                password_login.requestFocus();
            } else if (!(email_login.text.isEmpty() && password_login.text.isEmpty())) {


//                MainActivity.client.logToApp(
//                    LoginDto(
//                        email = email_login.text.toString(),
//                        password = password_login.text.toString()
//                    )
//                )
//                    .enqueue(object : Callback<UserDTO> {
//                        override fun onResponse(
//                            call: Call<UserDTO>,
//                            response: retrofit2.Response<UserDTO>
//                        ) {
//                            if(response.code()==200){
//                                val sharedPreferences =
//                                    context.getSharedPreferences(
//                                        "Preferences_User_Data",
//                                        Context.MODE_PRIVATE
//                                    )
//                                val editor = sharedPreferences.edit()
//                                editor.putBoolean("isLogged", true)
//                                editor.putLong("ID",response.body()!!.ID)
//                                editor.putString("email",response.body()!!.email)
//                                editor.putString("username",response.body()!!.username)
//                                editor.putString("city",response.body()!!.city)
//                                editor.putString("phoneNumber",response.body()!!.phoneNumber)
//                                editor.putString("typeUser",response.body()!!.typeUser)
//                                editor.putString("street",response.body()!!.street)
//                                editor.apply()

                                Toast.makeText(
                                    context,
                                    R.string.youhavesuccesfullyloggedin,
                                    Toast.LENGTH_SHORT
                                ).show()

//                                fragmentManager.beginTransaction()
//                                    .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
//                                    .replace(R.id.containerForFragment, profileFragment)
//                                    .commit()
//                            }else if(response.code()==404){
//                                Toast.makeText(context, "incorrect password or username", Toast.LENGTH_SHORT)
//                                    .show();
//                            }else if(response.code()==401){
//                                Toast.makeText(context, "account is not active", Toast.LENGTH_SHORT)
//                                    .show();
//                            }else{
//                                Toast.makeText(context, "unkown error", Toast.LENGTH_SHORT)
//                                    .show();
//                            }

//                        }

//                        override fun onFailure(call: Call<UserDTO>, t: Throwable) {
//
//                        }
//                    }
//        )


//            }

//            textGoRegister.setOnClickListener { view ->
//                fragmentManager.beginTransaction()
//                    .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
//                    .replace(R.id.containerForFragment, registerFragment).commit()
//
            }
        }
    }
}