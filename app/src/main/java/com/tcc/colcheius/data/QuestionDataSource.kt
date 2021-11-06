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
            ),
            Question(
                text = "Entre as propriedades do som, qual das seguintes nos permite reconhecer a origem do som?",
                answers = listOf(
                    "Timbre",
                    "Melodia",
                    "Altura",
                    "Intensidade"
                )
            )
        )
    }

    fun getModuleTwoQuestions(): MutableList<Question> {
        return  mutableListOf(
            Question(
                text = "Qual figura tem a maior duração?",
                answers = listOf(
                    "Semibreve",
                    "Colcheia",
                    "Mínima",
                    "Fusa"
                )
            ),
            Question(
                text = "Qual das alternativas abaixo contém a figura de MAIOR duração entre elas?",
                answers = listOf(
                    "Semínima",
                    "Colcheia",
                    "Semifusa",
                    "Semicolcheia"
                )
            ),
            Question(
                text = "Qual das alternativas abaixo contém a figura de MENOR duração entre elas?",
                answers = listOf(
                    "Semicolcheia",
                    "Semibreve",
                    "Colcheia",
                    "Mínima"
                )
            ),
            Question(
                text = "Quantas Mínimas seriam necessárias para representar o mesmo valor de 1 Semibreve?",
                answers = listOf(
                    "2",
                    "4",
                    "6",
                    "Nenhuma das alternativas anteriores"
                )
            )
        )

    }
}