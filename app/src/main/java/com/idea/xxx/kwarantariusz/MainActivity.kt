package com.idea.xxx.kwarantariusz

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentManager
import com.idea.xxx.kwarantariusz.RetrofitClient.RetrofitClientInstance
import com.idea.xxx.kwarantariusz.Service.KwarantariuszApiService
import com.idea.xxx.kwarantariusz.WelcomePages.ViewPagerFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    companion object {
        val client: KwarantariuszApiService = RetrofitClientInstance.makeRetrofitService()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // WAY TO ADD A FRAGMENT
        val fragmentManager: FragmentManager = supportFragmentManager
        val instructionsMainFragment = ViewPagerFragment()
        val profileFragment = ProfileFragment()
        val registerFragment = RegisterFragment()
        val tableOrderFragment = TableOrderFragment()


        fragmentManager.beginTransaction().add(R.id.containerForFragment, instructionsMainFragment).commit()
        bottom_nav_bar.menu.getItem(0).setCheckable(false)


        bottom_nav_bar.setOnNavigationItemSelectedListener { menuItem ->

            bottom_nav_bar.menu.getItem(0).setCheckable(true)


            menuItem.isChecked = true

            when (menuItem.itemId) {

                R.id.profile_item -> {


                    val sharedPreferences =
                        this.getSharedPreferences("Preferences_User_Data", Context.MODE_PRIVATE)
                    val isLogged = sharedPreferences.getBoolean("isLogged", false)

                    if (isLogged) {
                        fragmentManager.beginTransaction()
                            .setCustomAnimations(
                                R.anim.in_left_down_corner,
                                R.anim.out_right_up_corner
                            )
                            .replace(R.id.containerForFragment, profileFragment).commit()
                    } else {
                        fragmentManager.beginTransaction()
                            .setCustomAnimations(
                                R.anim.in_left_down_corner,
                                R.anim.out_right_up_corner
                            )
                            .replace(R.id.containerForFragment, registerFragment).commit()
                    }


                }
                R.id.search_item -> {
                    fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
                        .replace(R.id.containerForFragment, tableOrderFragment).commit()
                }
                R.id.settings_item -> {
                    fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
                        .replace(R.id.containerForFragment, registerFragment).commit()
                }
            }


            true
        }


        nav_view.setNavigationItemSelectedListener { menuItem ->

            menuItem.isChecked = true
            drawer_layout.closeDrawers()

            when (menuItem.itemId) {

                R.id.profile_item -> {

                    fragmentManager.beginTransaction()
                        .replace(R.id.containerForFragment, registerFragment).commit()
                }
                R.id.search_item -> {
                    fragmentManager.beginTransaction()
                        .replace(R.id.containerForFragment, profileFragment).commit()
                }
                R.id.settings_item -> {
//                    fragmentManager.beginTransaction()
//                        .replace(R.id.containerForFragment, paymentDetailsFragment).commit()
                }
            }

            true
        }

    }


}
