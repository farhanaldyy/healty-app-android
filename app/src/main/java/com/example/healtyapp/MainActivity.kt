package com.example.healtyapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import com.example.healtyapp.activity.LoginActivity
import com.example.healtyapp.activity.MasukActivity
import com.example.healtyapp.fragment.AccountFragment
import com.example.healtyapp.fragment.HomeFragment
import com.example.healtyapp.fragment.PoliFragment
import com.example.healtyapp.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHome : Fragment = HomeFragment()
    val fragmentPoli : Fragment = PoliFragment()
    val fragmentAccount : Fragment = AccountFragment()
    val fm : FragmentManager = supportFragmentManager
    var active : Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private var setStatusLogin = false

    // var validasi login sharedpref
    private lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setBottomNav()

    }

    fun setBottomNav() {

        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentPoli).hide(fragmentPoli).commit()
        fm.beginTransaction().add(R.id.container, fragmentAccount).hide(fragmentAccount).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener {item ->

            when (item.itemId){
                R.id.navigation_home -> {
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_poli -> {
                    callFragment(1, fragmentPoli)
                }
                R.id.navigation_account -> {
                    if(s.getStatusLogin()) { // get boolean status dari sharedpref
                        callFragment(2, fragmentAccount)
                    } else {
                        startActivity(Intent(this, MasukActivity::class.java))
                    }
                }
            }
            false
        }

    }

    fun callFragment(int : Int , fragment: Fragment){

        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment

    }
}