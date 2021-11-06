package com.tcc.colcheius.view.modulo2

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.tcc.colcheius.R
import com.tcc.colcheius.view.QuestionsActivity

class GravesAgudosFragment : Fragment() {

    private var module :Int? = 0
    private lateinit var figurasFragment: FigurasFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        module = activity?.intent?.extras?.getInt("module")
        figurasFragment = FigurasFragment()
        val view = inflater.inflate(R.layout.fragment_graves_agudos, container, false)

        val btnContinue : Button = view.findViewById(R.id.btnContinue)
        btnContinue.setOnClickListener {
            showDialog()
        }
        return view
    }

    private fun showDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("ESTÁ PRONTO PARA PROSSEGUIR?")
            .setMessage("A seguir serão apresentados exercícios para fixar o conteúdo abordado.\nCaso deseje voltar, pressione \"Revisar\" abaixo.")
            .setCancelable(false)
            .setPositiveButton("PROSSEGUIR", DialogInterface.OnClickListener { _, _ ->
                val intent = Intent(requireContext(), QuestionsActivity::class.java)
                intent.putExtra("module", module)
                startActivity(intent)
                activity?.finish()
            })
            .setNegativeButton("REVISAR", DialogInterface.OnClickListener { _, _ ->
                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.container_lesson,figurasFragment)
                    commit()
                }
            }).show()
    }
}