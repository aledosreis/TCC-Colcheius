package com.tcc.colcheius.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import com.tcc.colcheius.R
import com.tcc.colcheius.model.User

class ProfileFragment : Fragment() {

    private var user: User? = null
    private lateinit var imageProfile: ImageView
    private lateinit var userName: TextView
    private lateinit var scoreTotal: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        imageProfile = view.findViewById(R.id.image_profile)
        userName = view.findViewById(R.id.username)
        scoreTotal = view.findViewById(R.id.score_qtd)

        val btLogout: TextView = view.findViewById(R.id.logout)
        btLogout.setOnClickListener {
            logoutUser()
        }

        loadUserData()
        return view
    }

    /**
     * Método responsável por recuperar os dados do usuário atual conectado.
     */
    private fun loadUserData() {
        val connectedUserId = FirebaseAuth.getInstance().uid.toString()

        FirebaseFirestore.getInstance().collection("users")
            .document(connectedUserId)
            .get()
            .addOnSuccessListener { document ->
                user = document?.toObject(User::class.java)
                scoreTotal.text = user?.totalScore.toString()
                userName.text = user?.userName.toString()

                if (user?.profileImg != "")
                    Picasso.get().load(user?.profileImg).into(imageProfile)
            }
    }

    /**
     * Método responsável por realizar o logout do usuário.
     */
    private fun logoutUser() {
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(requireContext(), StartActivity::class.java))
        activity?.finish()
    }
}