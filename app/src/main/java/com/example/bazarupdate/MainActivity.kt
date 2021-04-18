package com.example.bazarupdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bazarupdate.App.App_Fragment
import com.example.bazarupdate.Movie.Movie_Fragment
import com.example.bazarupdate.Game.Game_Fragment
import com.example.bazarupdate.Profile.Profile_Fragment
import com.example.bazarupdate.Search.Search_Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nav_buttom = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val gameFragment = Game_Fragment()
        val searchFragment = Search_Fragment()
        val filmFragment = Movie_Fragment()
        val appFragment = App_Fragment()
        val profileFragment = Profile_Fragment()

        createFragment(gameFragment)

        nav_buttom.setOnNavigationItemSelectedListener {
            when (it.itemId) {


                R.id.tab_game -> createFragment(gameFragment)
                R.id.tab_app -> createFragment(appFragment)
                R.id.tab_film -> createFragment(filmFragment)
                //R.id.tab_search -> createFragment(searchFragment)
                R.id.tab_profile -> createFragment(profileFragment)
            }
            true
        }

    }

    private fun createFragment(fragment: Fragment) {

        var transAction = manager.beginTransaction()
        transAction.replace(R.id.fram_parent, fragment)
        transAction.commit()

    }


}