package com.example.fragment_fadhluibnu_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_fadhluibnu_10.fragment.HomeFragment
import com.example.fragment_fadhluibnu_10.fragment.NotificationFragment
import com.example.fragment_fadhluibnu_10.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notifFragment = NotificationFragment()
        val settingFragment = SettingFragment()

        makeCurrentFragment(homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.notification -> makeCurrentFragment(notifFragment)
                R.id.setting -> makeCurrentFragment(settingFragment)

            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.frame_nav, fragment)
            commit()
        }
    }
}