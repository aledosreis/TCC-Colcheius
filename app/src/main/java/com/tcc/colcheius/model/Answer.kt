package com.tcc.colcheius.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Answer(
    var questionText : String,
    var answerSelected : String,
    var correctAnswer : String
) : Parcelable