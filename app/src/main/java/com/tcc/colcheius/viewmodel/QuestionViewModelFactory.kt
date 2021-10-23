package com.tcc.colcheius.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tcc.colcheius.model.Answer

class QuestionViewModelFactory(
    private val module: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
            return QuestionViewModel(module) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}