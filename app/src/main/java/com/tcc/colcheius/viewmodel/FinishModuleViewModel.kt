package com.tcc.colcheius.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcc.colcheius.model.Answer

class FinishModuleViewModel(
    module: Int,
    finalScore: Int,
    percentCorrect: Float,
    answers: ArrayList<Answer>
) : ViewModel() {

    private var _module = MutableLiveData<Int>()
    val module: LiveData<Int> get() = _module

    private var _percent = MutableLiveData<Float>()
    val percent: LiveData<Float> get() = _percent

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int> get() = _score

    private var _answersArray = MutableLiveData<ArrayList<Answer>>()
    val answersArray: LiveData<ArrayList<Answer>> get() = _answersArray

    init {
        _module.value = module
        _percent.value = percentCorrect
        _score.value = finalScore
        _answersArray.value = answers
    }
}