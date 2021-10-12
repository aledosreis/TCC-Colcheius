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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

class RankingFragment : Fragment() {

    private lateinit var adapter : GroupAdapter<ViewHolder>
    val mapUserScore = mutableMapOf("Alessandro" to 100, "Caynã" to 95, "Outro cara" to 50)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_ranking, container, false)
        val recyclerView : RecyclerView = view.findViewById(R.id.ranking_list)
        adapter = GroupAdapter<ViewHolder>()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

//        for (item in mapUserScore) {
//            adapter.add(RankingItem(item.key, item.value))
//        }

        loadRanking()

        return view
    }

    private fun loadRanking() {
        FirebaseFirestore.getInstance().collection("users")
            .orderBy("totalScore", Query.Direction.DESCENDING)
            .limit(100)
            .addSnapshotListener { value, error ->
                if (error != null)
                    return@addSnapshotListener
                val documents = value?.documents
                if (documents != null) {
                    for (document in documents) {
                        val user = document.toObject(User::class.java)
                        adapter.add(RankingItem(user!!))
                    }
                }
            }
    }


    private inner class RankingItem(val user : User) : Item<ViewHolder>() {
        override fun bind(viewHolder: ViewHolder, position: Int) {
            val tvUsername : TextView = viewHolder.itemView.findViewById(R.id.user_name)
            val tvScore : TextView = viewHolder.itemView.findViewById(R.id.user_score)
            val ivPhoto : ImageView = viewHolder.itemView.findViewById(R.id.profile_image)

            tvUsername.text = user.userName
            tvScore.text = user.totalScore.toString()

            Picasso.get().load(user.profileImg).into(ivPhoto)
        }

        override fun getLayout(): Int {
            return R.layout.item_list_ranking
        }

    }
}