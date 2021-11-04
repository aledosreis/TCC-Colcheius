package com.tcc.colcheius.view.modulo1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.tcc.colcheius.R
import com.tcc.colcheius.view.QuestionsActivity

class SongPropertyTheoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_song_property, container, false)

        val module = activity?.intent?.extras?.getInt("module")

        val btnContinue : Button = view.findViewById(R.id.btnContinue)
        btnContinue.setOnClickListener {
//            Toast.makeText(requireContext(), module.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), QuestionsActivity::class.java)
            intent.putExtra("module", module)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }

}