package com.tcc.colcheius.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tcc.colcheius.R

class LessonTheoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_therory)

        val module = intent.extras?.getInt("module")


        val whatIsMusicTheoryFragment = WhatIsMusicTheoryFragment()

        when(module) {
            1 -> changeScreen(fragment = whatIsMusicTheoryFragment)
        }
    }

    private fun changeScreen(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_lesson,fragment)
            commit()
        }
    }
}