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
import com.idea.xxx.kwarantariusz.WelcomePages.ViewPagerFragment
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

//    companion object {
//        val client: LearnApiService = RetrofitClientInstance.makeRetrofitService()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // WAY TO ADD A FRAGMENT
        val fragmentManager: FragmentManager = supportFragmentManager
        val instructionsMainFragment = ViewPagerFragment()
//        val registerFragment = RegisterFragment()


        fragmentManager.beginTransaction().add(R.id.containerForFragment, instructionsMainFragment)
            .commit()
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
                        .replace(R.id.containerForFragment, searchFragment).commit()
                }
                R.id.settings_item -> {
                    fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.in_left_down_corner, R.anim.out_right_up_corner)
//                       .setCustomAnimations(R.anim.design_snackbar_in, R.anim.abc_shrink_fade_out_from_bottom)
                        .replace(R.id.containerForFragment, settingsFragment).commit()
                }
            }


            true
        }


        nav_view.setNavigationItemSelectedListener { menuItem ->

            menuItem.isChecked = true
            drawer_layout.closeDrawers()

            when (menuItem.itemId) {

                R.id.profile_item -> {

                    //val intent = Intent(this, MapsActivity::class.java)
                    //startActivity(intent)

                    fragmentManager.beginTransaction()
                        .replace(R.id.containerForFragment, registerFragment).commit()
                    //fragmentManager.beginTransaction().replace(R.id.containerForFragment, profileFragment).commit()
                }
                R.id.search_item -> {
                    fragmentManager.beginTransaction()
                        .replace(R.id.containerForFragment, profileFragment).commit()
                }
                R.id.settings_item -> {
//                    fragmentManager.beginTransaction()
//                        .replace(R.id.containerForFragment, paymentDetailsFragment).commit()
                    startActivity(Intent(this, MyPayPalPaymentActivity::class.java))
                }
            }

            true
        }


//        val host = NavHostFragment.create(R.navigation.nav_graph)
//        supportFragmentManager.beginTransaction().replace(R.id.containerForFragment, host).setPrimaryNavigationFragment(host).commit()
    }


    //  This function is called in onCreate()
    fun createNotificationChannel(
        context: Context,
        importance: Int,
        showBadge: Boolean,
        name: String,
        description: String
    ) {

        //  Checking SDK version (for security reasons)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channelId = "L_Earn_Channel"
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)


            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}
