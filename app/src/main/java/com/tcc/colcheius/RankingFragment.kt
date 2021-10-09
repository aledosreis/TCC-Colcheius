package com.tcc.colcheius

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

class RankingFragment : Fragment() {

    val mapUserScore = mutableMapOf("Alessandro" to 100, "Caynã" to 95, "Outro cara" to 50)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_ranking, container, false)
        val recyclerView : RecyclerView = view.findViewById(R.id.ranking_list)
        val adapter : GroupAdapter<ViewHolder> = GroupAdapter<ViewHolder>()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        for (item in mapUserScore) {
            adapter.add(RankingItem(item.key, item.value))
        }

        return view
    }

    private inner class RankingItem(val username : String, val score : Int) : Item<ViewHolder>() {
        override fun bind(viewHolder: ViewHolder, position: Int) {
            val tvUsername : TextView = viewHolder.itemView.findViewById(R.id.user_name)
            val tvScore : TextView = viewHolder.itemView.findViewById(R.id.user_score)

            tvUsername.text = username
            tvScore.text = score.toString()
        }

        override fun getLayout(): Int {
            return R.layout.item_list_ranking
        }

    }
}