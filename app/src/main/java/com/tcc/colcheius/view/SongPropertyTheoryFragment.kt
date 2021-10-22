package com.tcc.colcheius.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.tcc.colcheius.R

class SongPropertyTheoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_song_property, container, false)

        val btnContinue : Button = view.findViewById(R.id.btnContinue)
        btnContinue.setOnClickListener {
            startActivity(Intent(requireContext(), QuestionsActivity::class.java))
            activity?.finish()
        }

        return view
    }

}