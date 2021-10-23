package com.tcc.colcheius.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcc.colcheius.data.QuestionDataSource
import com.tcc.colcheius.model.Answer
import com.tcc.colcheius.model.Question

class QuestionViewModel(module : Int) : ViewModel() {

    // lista de questões
    private lateinit var questions: MutableList<Question>

    private var questionIndex: Int
    private var answerIndex: Int
    private var numQuestions: Int
    private var correctQuestions: Int

    // Variáveis observadas pela view
    private var _answers = MutableLiveData<MutableList<String>>()
    val answers: LiveData<MutableList<String>> get() = _answers

    private var _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> get() = _currentQuestion

    private var _isQuestionsDone = MutableLiveData<Boolean>()
    val isQuestionsDone : LiveData<Boolean> get() = _isQuestionsDone

    private var _isAnswerCorrect = MutableLiveData<Boolean>()
    val isAnswerCorrect : LiveData<Boolean> get() = _isAnswerCorrect

    private var _percent = MutableLiveData<Float>()
    val percent : LiveData<Float> get() = _percent

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int> get() = _score

    private var _module = MutableLiveData<Int>()
    val module: LiveData<Int> get() = _module

    private var _answerList = MutableLiveData<MutableList<Answer>>()
    val answerList : LiveData<MutableList<Answer>> get() = _answerList

    init {
        _module.value = module
        getQuestionList()
        questionIndex = 0
        numQuestions = questions.size
        correctQuestions = 0
        _score.value = 0
        answerIndex = -1
        _isQuestionsDone.value = false
        _isAnswerCorrect.value = false
        _answers.value = mutableListOf()
        _answerList.value = mutableListOf()
        randomizeQuestions()
    }

    private fun getQuestionList() {
        when(module.value) {
            1 -> questions = QuestionDataSource().getModuleOneQuestions()
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
        _currentQuestion.value = questions[questionIndex]
        _answers.value = currentQuestion.value?.answers?.toMutableList()
        _answers.value?.shuffle()
    }

    fun checkAnswer(answerSelected: Int) {

        val answer = Answer(
            questionText = currentQuestion.value?.text.toString(),
            answerSelected = answers.value?.get(answerSelected).toString(),
            correctAnswer = currentQuestion.value?.answers?.get(0).toString()
        )
        _answerList.value?.add(answer)

        if (answers.value?.get(answerSelected) == currentQuestion.value?.answers?.get(0)) {
            correctQuestions++
            _score.value = score.value?.plus(10)
            _isAnswerCorrect.value = true
        } else _isAnswerCorrect.value = false

        questionIndex++
        if (questionIndex < numQuestions) {
            setQuestion()
        } else {
            // Quando acabar a lição dar pontos extras se acertar todas as questões
            if (correctQuestions == numQuestions) _score.value = score.value?.plus(5)
            _percent.value = correctQuestions.toFloat() / numQuestions.toFloat() * 100
            onQuestionsDone()
        }
    }

    private fun onQuestionsDone() {
        _isQuestionsDone.value = true
    }
}