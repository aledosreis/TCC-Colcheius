package com.tcc.colcheius

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

class LessonsFragment : Fragment() {

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
        val recyclerView: RecyclerView = view.findViewById(R.id.lesson_list)

        val adapter: GroupAdapter<ViewHolder> = GroupAdapter<ViewHolder>()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        for (module in modules) {
            adapter.add(ModuleItem(module))
        }

        return view
    }

    private inner class ModuleItem(var moduleName: String) : Item<ViewHolder>() {
        override fun bind(viewHolder: ViewHolder, position: Int) {
            val tvModuleName: TextView = viewHolder.itemView.findViewById(R.id.module_name)
            val imageGoOn : ImageView = viewHolder.itemView.findViewById(R.id.go_on_btn)
            tvModuleName.text = moduleName
            if (moduleName != "Módulo 1") {
                imageGoOn.setImageResource(R.drawable.ic_lock)
            }
        }

        override fun getLayout(): Int {
            return R.layout.item_list_module
        }

    }
}