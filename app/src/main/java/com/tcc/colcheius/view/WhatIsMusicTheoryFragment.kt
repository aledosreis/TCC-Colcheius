package com.tcc.colcheius.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.tcc.colcheius.R

class WhatIsMusicTheoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rhythmTheoryFragment = RhythmTheoryFragment()
        val view = inflater.inflate(R.layout.fragment_what_is_music, container, false)

        val btnContinue : Button = view.findViewById(R.id.btnContinue)
        btnContinue.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.container_lesson, rhythmTheoryFragment)
                commit()
            }
        }

        return view
    }
}