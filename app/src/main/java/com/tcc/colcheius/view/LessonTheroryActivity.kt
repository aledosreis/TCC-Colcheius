package com.tcc.colcheius.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.tcc.colcheius.R

class LessonTheroryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_therory)

        val btnContinue : Button = findViewById(R.id.btnContinue)
        btnContinue.setOnClickListener {
            startActivity(Intent(this, QuestionsActivity::class.java))
            finish()
        }
    }
}