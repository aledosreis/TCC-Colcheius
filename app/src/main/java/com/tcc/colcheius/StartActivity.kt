package com.tcc.colcheius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verifyAuthentication()

        setContentView(R.layout.activity_start)

        val btLogin = findViewById<Button>(R.id.bt_login)
        val tvNewAccount = findViewById<TextView>(R.id.tv_new_acc)

        btLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        tvNewAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun verifyAuthentication() {
        if (FirebaseAuth.getInstance().uid != null) {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }
}