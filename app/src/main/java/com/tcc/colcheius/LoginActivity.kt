package com.tcc.colcheius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail : EditText = findViewById(R.id.et_email)
        val etPassword : EditText = findViewById(R.id.et_password)
        val btLogin = findViewById<Button>(R.id.bt_login)

        btLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty())
                loginUser(email, password)
            else
                Toast.makeText(applicationContext, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Método responsável por realizar o login do usuário.
     */
    private fun loginUser(email : String, password : String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            }
    }
}