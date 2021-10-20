package com.tcc.colcheius.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import com.tcc.colcheius.R
import com.tcc.colcheius.model.User
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

class LessonsFragment : Fragment() {

    private var user : User? = null
    private lateinit var userImage : ImageView
    private lateinit var userGreetings : TextView
    private lateinit var userScore : TextView

    private lateinit var adapter: GroupAdapter<ViewHolder>
    private val modules = mutableListOf(
        "Módulo 1",
        "Módulo 2",
        "Módulo 3",
        "Módulo 4",
        "Módulo 5",
        "Módulo 6",
        "Módulo 7",
        "Módulo 8",
        "Módulo 9",
        "Módulo 10"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_lessons, container, false)

        userImage = view.findViewById(R.id.user_photo)
        userGreetings = view.findViewById(R.id.user_greetings)
        userScore = view.findViewById(R.id.user_score)

        val recyclerView: RecyclerView = view.findViewById(R.id.lesson_list)

        adapter = GroupAdapter<ViewHolder>()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        loadUserData()

        return view
    }

    private fun loadModules() {
        for (module in modules) {
            adapter.add(ModuleItem(module))
        }
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
                userScore.text = user?.totalScore.toString()
                userGreetings.text = getString(R.string.hello_user, user?.userName)

                Picasso.get().load(user?.profileImg).into(userImage)

                loadModules()
            }
    }

    private inner class ModuleItem(var moduleName: String) : Item<ViewHolder>() {
        override fun bind(viewHolder: ViewHolder, position: Int) {
            val tvModuleName: TextView = viewHolder.itemView.findViewById(R.id.module_name)
            val imageGoOn: ImageView = viewHolder.itemView.findViewById(R.id.go_on_btn)
            tvModuleName.text = moduleName
            if (moduleName !in user?.unlockedModules!!) {
                imageGoOn.setImageResource(R.drawable.ic_lock)
                imageGoOn.setOnClickListener {
                    Toast.makeText(requireContext(), getString(R.string.complete_previous_first), Toast.LENGTH_SHORT).show()
                }
            } else {
                imageGoOn.setOnClickListener {
                    startActivity(Intent(requireContext(), LessonTheroryActivity::class.java))
                }
            }
        }

        override fun getLayout(): Int {
            return R.layout.item_list_module
        }

    }
}