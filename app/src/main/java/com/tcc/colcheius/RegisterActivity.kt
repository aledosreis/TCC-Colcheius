package com.tcc.colcheius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val ivProfile : ImageView = findViewById(R.id.iv_profile_photo)
        val etName : EditText = findViewById(R.id.et_name)
        val etEmail : EditText = findViewById(R.id.et_email)
        val etPassword : EditText = findViewById(R.id.et_password)
        val btRegister : Button = findViewById(R.id.bt_register)

        btRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            //Verificar se todos os campos foram preenchidos.
            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty())
                registerUser(email, password)
            else Toast.makeText(applicationContext, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Método responsável por realizar a criação do usuário no Firebase.
     */
    private fun registerUser(email : String, password : String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            }
    }
}