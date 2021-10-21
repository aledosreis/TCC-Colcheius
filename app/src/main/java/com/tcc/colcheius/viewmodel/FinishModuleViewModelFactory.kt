package com.tcc.colcheius.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tcc.colcheius.model.Answer

class FinishModuleViewModelFactory(
    private val module: Int,
    private val finalScore: Int,
    private val percentCorrect: Float,
    private val answers: ArrayList<Answer>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FinishModuleViewModel::class.java)) {
            return FinishModuleViewModel(module, finalScore, percentCorrect, answers) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}