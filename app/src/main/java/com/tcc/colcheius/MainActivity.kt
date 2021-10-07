package com.tcc.colcheius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val lessonsFragment = LessonsFragment()
        val profileFragment = ProfileFragment()
        val rankingFragment = RankingFragment()

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ranking -> changeScreen(rankingFragment)
                R.id.profile -> changeScreen(profileFragment)
                R.id.lessons -> changeScreen(lessonsFragment)
            }
            true
        }

        bottomNavigationView.selectedItemId = R.id.lessons

    }

    private fun changeScreen(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }
    }
}