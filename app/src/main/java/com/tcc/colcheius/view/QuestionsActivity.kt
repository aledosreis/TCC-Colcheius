package com.tcc.colcheius.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tcc.colcheius.viewmodel.QuestionViewModel
import com.tcc.colcheius.R

class QuestionsActivity : AppCompatActivity() {

    private lateinit var textQuestion: TextView
    private lateinit var answersGroup: RadioGroup
    private lateinit var answer1: RadioButton
    private lateinit var answer2: RadioButton
    private lateinit var answer3: RadioButton
    private lateinit var answer4: RadioButton
    private lateinit var btnConfirm: Button

    private lateinit var questionViewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questionViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        textQuestion = findViewById(R.id.question)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)

        answersGroup = findViewById(R.id.answers)

        getQuestion()

        btnConfirm = findViewById(R.id.confirm_button)
        btnConfirm.setOnClickListener {
            checkAnswer()
        }
    }

    private fun getQuestion() {
        textQuestion.text = questionViewModel.currentQuestion.value?.text
        answer1.text = questionViewModel.answers.value?.get(0)
        answer2.text = questionViewModel.answers.value?.get(1)
        answer3.text = questionViewModel.answers.value?.get(2)
        answer4.text = questionViewModel.answers.value?.get(3)
    }

    private fun checkAnswer() {
        val checkedId = answersGroup.checkedRadioButtonId

        if (checkedId != -1) {
            var answerIndex = -1

            when (checkedId) {
                R.id.answer1 -> answerIndex = 0
                R.id.answer2 -> answerIndex = 1
                R.id.answer3 -> answerIndex = 2
                R.id.answer4 -> answerIndex = 3
            }

            questionViewModel.checkAnswer(answerIndex)

            answersGroup.clearCheck()

            if (questionViewModel.isQuestionsDone.value == true) {
                val intent = Intent(this, FinishModuleActivity::class.java)
                intent.putExtra("score", questionViewModel.score.value)
                intent.putExtra("percent", questionViewModel.percent.value)
                intent.putParcelableArrayListExtra(
                    "answerList",
                    ArrayList(questionViewModel.answerList.value?.toMutableList()!!)
                )
                startActivity(intent)
                finish()
            } else getQuestion()
        }
    }
}