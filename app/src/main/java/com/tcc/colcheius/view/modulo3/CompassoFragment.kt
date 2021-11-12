package com.tcc.colcheius.view.modulo3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.tcc.colcheius.R

class CompassoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val barrasCompassoFragment = BarrasCompassoFragment()
        val view = inflater.inflate(R.layout.fragment_compasso, container, false)

        val btnContinue : Button = view.findViewById(R.id.bt_continue)
        btnContinue.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.container_lesson, barrasCompassoFragment)
                commit()
            }
        }

        return view
    }
}