package com.tcc.colcheius.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.tcc.colcheius.R

class GravesAgudosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val module = activity?.intent?.extras?.getInt("module")
        val view = inflater.inflate(R.layout.fragment_graves_agudos, container, false)

        val btnContinue : Button = view.findViewById(R.id.btnContinue)
        btnContinue.setOnClickListener {
            val intent = Intent(requireContext(), QuestionsActivity::class.java)
            intent.putExtra("module", module)
            startActivity(intent)
            activity?.finish()
        }
        return view
    }
}