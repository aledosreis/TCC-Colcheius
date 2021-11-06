package com.tcc.colcheius.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.tcc.colcheius.R

class LoginActivity : AppCompatActivity() {

    private lateinit var progressLogin: ProgressBar
    private lateinit var textProgressLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressLogin = findViewById(R.id.progressLogin)
        textProgressLogin = findViewById(R.id.textProgressLogin)

        val etEmail : EditText = findViewById(R.id.et_email)
        val etPassword : EditText = findViewById(R.id.et_password)
        val btLogin = findViewById<Button>(R.id.bt_login)

        btLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                progressLogin.visibility = View.VISIBLE
                textProgressLogin.visibility = View.VISIBLE
                loginUser(email, password)
            }
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
                progressLogin.visibility = View.INVISIBLE
                textProgressLogin.visibility = View.INVISIBLE
                if (it.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            }
            .addOnFailureListener { e ->
                Log.e("LoginAct", e.message, e)
                when(e) {
                    is FirebaseAuthInvalidCredentialsException -> errorDialog("Email ou senha incorretos.")
                    is FirebaseAuthInvalidUserException -> errorDialog("Não existe usuário com este email.")
                }
            }
    }

    private fun errorDialog(message : String) {
        AlertDialog.Builder(this)
            .setTitle("Erro no login")
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton("OK", null)
            .show()
    }
}