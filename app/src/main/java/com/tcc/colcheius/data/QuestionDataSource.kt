package com.tcc.colcheius.data

import com.tcc.colcheius.model.Question

class QuestionDataSource {

    fun getModuleOneQuestions(): MutableList<Question> {
        return mutableListOf(
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
    }
}