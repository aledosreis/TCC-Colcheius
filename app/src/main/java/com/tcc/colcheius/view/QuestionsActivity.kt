package com.tcc.colcheius.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.tcc.colcheius.R
import com.tcc.colcheius.model.Answer
import com.tcc.colcheius.model.Question

class QuestionsActivity : AppCompatActivity() {

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "O que é música?",
            answers = listOf(
                "Arte de se expressar através dos sons",
                "Qualquer som produzido pela natureza",
                "Qualquer som que nosso ouvido reconhece",
                "Arte de ouvir e reconhecer origem dos sons"
            )
        ),
        Question(
            text = "Qual foi a primeira manifestação musical do homem?",
            answers = listOf(
                "Ritmo",
                "Dança",
                "k-pop",
                "Som de animais"
            )
        ),
        Question(
            text = "O que é ritmo?",
            answers = listOf(
                "Divisão ordenada do tempo, representa por batidas",
                "Combinação de sons que se encaixam perfeitamente",
                "O melhor amigo do músico",
                "Todos os sons que possuem tempo e silêncio"
            )
        )
    )

    private lateinit var textQuestion: TextView
    private lateinit var answersGroup: RadioGroup
    private lateinit var answer1: RadioButton
    private lateinit var answer2: RadioButton
    private lateinit var answer3: RadioButton
    private lateinit var answer4: RadioButton
    private lateinit var btnConfirm: Button

    private lateinit var currentQuestion: Question
    private lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = questions.size

    private var correctQuestions = 0
    private var score = 0
    private var percent = 0
    private val answerList = mutableListOf<Answer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        intent = Intent(this, FinishModuleActivity::class.java)

        textQuestion = findViewById(R.id.question)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)

        answersGroup = findViewById(R.id.answers)

        randomizeQuestions()

        btnConfirm = findViewById(R.id.confirm_button)
        btnConfirm.setOnClickListener {
            checkAnswer()
        }
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

            val answer = Answer(
                questionText = currentQuestion.text,
                answerSelected = answers[answerIndex],
                correctAnswer = currentQuestion.answers[0]
            )
            answerList.add(answer)


            if (answers[answerIndex] == currentQuestion.answers[0]) {
                correctQuestions++
                score += 10
            }

            questionIndex++
            if (questionIndex < numQuestions) {
                answersGroup.clearCheck()
                setQuestion()
            } else {
                // Quando acabar a lição dar pontos extras se acertar todas as questões
                if (correctQuestions == numQuestions) score += 5

                percent = correctQuestions / numQuestions * 100

                intent.putExtra("score", score)
                intent.putExtra("percent", percent)
                intent.putParcelableArrayListExtra("answerList", ArrayList(answerList))

                startActivity(intent)
                finish()
            }
        }
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    /**
     * Método responsável por recuperar a pergunta atual e renderizar na tela
     */
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()

        //colocar pergunta e respostas na tela
        textQuestion.text = currentQuestion.text
        answer1.text = answers[0]
        answer2.text = answers[1]
        answer3.text = answers[2]
        answer4.text = answers[3]

    }

    companion object {
        lateinit var intent: Intent
    }
}