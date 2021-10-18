package com.tcc.colcheius.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tcc.colcheius.R
import com.tcc.colcheius.model.Answer
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

class FinishModuleActivity : AppCompatActivity() {

    private lateinit var resultTitle : TextView
    private lateinit var percentCorrect : TextView
    private lateinit var scoreQtd : TextView
    private lateinit var textReady : TextView
    private lateinit var btGoNextModule : Button
    private lateinit var recyclerResultList : RecyclerView

    private var module = 0
    private var percent = 0F
    private var score = 0
    private lateinit var answersArray : ArrayList<Answer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_module)

        resultTitle = findViewById(R.id.result_title)
        percentCorrect = findViewById(R.id.percent_correct)
        scoreQtd = findViewById(R.id.score_qtd)
        btGoNextModule = findViewById(R.id.bt_letsgo)
        textReady = findViewById(R.id.ready_to_next_module)
        recyclerResultList = findViewById(R.id.recycler_result)

        val adapter = GroupAdapter<ViewHolder>()
        recyclerResultList.adapter = adapter
        recyclerResultList.layoutManager = LinearLayoutManager(this)

        val extras : Bundle? = intent.extras

        if (extras != null) {
            module = extras.getInt("module")
            percent = extras.getFloat("percent")
            score = extras.getInt("score")
            answersArray = extras.getParcelableArrayList<Answer>("answerList") as ArrayList<Answer>
        }

        resultTitle.text = "GABARITO MÓDULO $module"
        percentCorrect.text = "Você acertou ${String.format("%.2f",percent)}% das questões"
        scoreQtd.text = score.toString()

        if (percent > 0) textReady.text = getString(R.string.congrats_go_to_next_module)
        else textReady.text = getString(R.string.need_try_again)

        for (item in answersArray) {
            adapter.add(ResultItem(item))
        }

        btGoNextModule.setOnClickListener {
            finish()
        }
    }

    private inner class ResultItem(val answer: Answer) : Item<ViewHolder>() {
        override fun bind(viewHolder: ViewHolder, position: Int) {
            val questionText : TextView = viewHolder.itemView.findViewById(R.id.question1)
            val answerText : TextView = viewHolder.itemView.findViewById(R.id.your_answer1)
            val correctAnswer : TextView = viewHolder.itemView.findViewById(R.id.correct_answer1)

            questionText.text = answer.questionText
            answerText.text = "Sua resposta: ${answer.answerSelected}"
            correctAnswer.text = "Resposta correta: ${answer.correctAnswer}"
        }

        override fun getLayout(): Int {
            return R.layout.item_list_results
        }

    }
}