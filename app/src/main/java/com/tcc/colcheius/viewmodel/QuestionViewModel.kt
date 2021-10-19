package com.tcc.colcheius.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcc.colcheius.data.QuestionDataSource
import com.tcc.colcheius.model.Answer
import com.tcc.colcheius.model.Question

class QuestionViewModel : ViewModel() {

    // lista de questões
    private lateinit var questions: MutableList<Question>
    private var questionIndex: Int

    private var answerIndex: Int

    private var numQuestions: Int

    private var correctQuestions: Int
    private var score: Int
    private val answerList = mutableListOf<Answer>()


    private var _answers = MutableLiveData<MutableList<String>>()
    val answers: LiveData<MutableList<String>> get() = _answers

    private var _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> get() = _currentQuestion

    init {
        getQuestionList()
        questionIndex = 0
        numQuestions = questions.size
        correctQuestions = 0
        score = 0
        answerIndex = -1

        _answers.value = mutableListOf()
        randomizeQuestions()
    }

    private fun getQuestionList() {
        questions = QuestionDataSource().getModuleOneQuestions()
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
        _currentQuestion.value = questions[questionIndex]
        _answers.value = currentQuestion.value?.answers?.toMutableList()
        _answers.value?.shuffle()
    }

    fun checkAnswer(anwerSelected: Int) {

        val answer = Answer(
            questionText = currentQuestion.value?.text.toString(),
            answerSelected = answers.value?.get(anwerSelected).toString(),
            correctAnswer = currentQuestion.value?.answers?.get(0).toString()
        )
        answerList.add(answer)

        if (answers.value?.get(anwerSelected) == currentQuestion.value?.answers?.get(0)) {
            correctQuestions++
            score += 10
        }

        questionIndex++
        if (questionIndex < numQuestions) {
            setQuestion()
        } else {
            // Quando acabar a lição dar pontos extras se acertar todas as questões
            if (correctQuestions == numQuestions) score += 5
            val percent = correctQuestions.toFloat() / numQuestions.toFloat() * 100
        }
    }
}