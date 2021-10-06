package com.tcc.colcheius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val lessonsFragment = LessonsFragment()
        val profileFragment = ProfileFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,profileFragment)
            commit()
        }
    }
}