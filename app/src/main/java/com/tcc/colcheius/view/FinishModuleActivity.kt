package com.tcc.colcheius.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.tcc.colcheius.R

class FinishModuleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_module)

        val btGoNextModule : Button = findViewById(R.id.bt_letsgo)
        btGoNextModule.setOnClickListener {
            finish()
        }
    }
}