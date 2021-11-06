package com.tcc.colcheius.view

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.tcc.colcheius.R
import com.tcc.colcheius.model.User

class RegisterActivity : AppCompatActivity() {
    private var selectedUri: Uri? = null
    private lateinit var ivProfile : ImageView
    private lateinit var progressRegister: ProgressBar
    private lateinit var textProgressRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        progressRegister = findViewById(R.id.progressRegister)
        textProgressRegister = findViewById(R.id.textProgressRegister)

        ivProfile = findViewById(R.id.iv_profile_photo)
        val etName : EditText = findViewById(R.id.et_name)
        val etEmail : EditText = findViewById(R.id.et_email)
        val etPassword : EditText = findViewById(R.id.et_password)
        val btRegister : Button = findViewById(R.id.bt_register)

        ivProfile.setOnClickListener {
            selectPhoto()
        }

        btRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            //Verificar se todos os campos foram preenchidos.
            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                progressRegister.visibility = View.VISIBLE
                textProgressRegister.visibility = View.VISIBLE
                registerUser(name, email, password)
            }
            else Toast.makeText(applicationContext, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun selectPhoto() {
        val intent = Intent(Intent.ACTION_PICK).setType("image/*")
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == RESULT_OK) {
            selectedUri = data?.data

            val bitmap : Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedUri)
            ivProfile.setImageBitmap(bitmap)
        }
    }

    /**
     * Método responsável por realizar a criação do usuário no Firebase.
     */
    private fun registerUser(name: String, email : String, password : String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                progressRegister.visibility = View.INVISIBLE
                textProgressRegister.visibility = View.INVISIBLE
                if (it.isSuccessful) {
                    val createdUserUid = it.result?.user?.uid.toString()
                    createUserData(name, createdUserUid)
                }
            }
            .addOnFailureListener { e ->
                Log.e("RegisterAct", e.message, e)
                when(e) {
                    is FirebaseAuthWeakPasswordException -> errorDialog("A senha precisa ter pelo menos 6 cacacteres.")
                    is FirebaseAuthInvalidCredentialsException -> errorDialog("Email inválido.")
                    is FirebaseAuthUserCollisionException -> errorDialog("Já existe um usuário cadastrado com este email.")
                }
            }
    }

    private fun createUserData(name: String, createdUserUid: String) {
        if (selectedUri != null) {
            val storageRef : StorageReference = FirebaseStorage.getInstance().getReference("/users/${createdUserUid}/${createdUserUid}")
            storageRef.putFile(selectedUri!!)
                .addOnSuccessListener {
                    storageRef.downloadUrl.addOnSuccessListener { uri ->
                        val profileUrl : String = uri.toString()
                        val user = User(userId = createdUserUid, userName = name, profileImg = profileUrl)
                        FirebaseFirestore.getInstance().collection("users")
                            .document(createdUserUid)
                            .set(user)
                            .addOnSuccessListener {
                                val intent = Intent(this, MainActivity::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                startActivity(intent)
                            }
                            .addOnFailureListener {
                                FirebaseAuth.getInstance().currentUser?.delete()
                                FirebaseStorage.getInstance().getReference("/users/${createdUserUid}").delete()
                            }
                    }
                }
                .addOnFailureListener {
                    Log.e("Register/Storage", it.message.toString())
                    FirebaseAuth.getInstance().currentUser?.delete()
                }
        }
        else {
            val user = User(userId = createdUserUid, userName = name)
            FirebaseFirestore.getInstance().collection("users")
                .document(createdUserUid)
                .set(user)
                .addOnSuccessListener {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    FirebaseAuth.getInstance().currentUser?.delete()
                }
        }
    }

    private fun errorDialog(message : String) {
        AlertDialog.Builder(this)
            .setTitle("Erro no cadastro")
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton("OK", null)
            .show()
    }
}