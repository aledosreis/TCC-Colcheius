package com.tcc.colcheius.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tcc.colcheius.R
import com.tcc.colcheius.view.modulo1.WhatIsMusicTheoryFragment
import com.tcc.colcheius.view.modulo2.FigurasFragment
import com.tcc.colcheius.view.modulo3.CompassoFragment

class LessonTheoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_therory)

        val module = intent.extras?.getInt("module")


        val whatIsMusicTheoryFragment = WhatIsMusicTheoryFragment()
        val figurasFragment = FigurasFragment()
        val compassoFragment = CompassoFragment()

        when(module) {
            1 -> changeScreen(fragment = whatIsMusicTheoryFragment)
            2 -> changeScreen(fragment = figurasFragment)
            3 -> changeScreen(fragment = compassoFragment)
        }
    }

    private fun changeScreen(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_lesson,fragment)
            commit()
        }
    }
}