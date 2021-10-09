package com.tcc.colcheius

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val btLogout : TextView = view.findViewById(R.id.logout)
        btLogout.setOnClickListener {
            logoutUser()
        }

        return view
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