package com.tcc.colcheius.model

class User(
    val userId: String,
    val userName: String,
    val totalScore : Int = 0,
    val profileImg: String = "",
    val unlockedModules: MutableList<String> = mutableListOf("Módulo 1")
) {
    constructor() : this("","",0,"", mutableListOf())
}