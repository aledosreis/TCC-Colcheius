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
                text = "Quais são os elementos mais importantes da música?",
                answers = listOf(
                    "Melodia, Harmonia e Ritmo",
                    "Tempo, som e silêncio",
                    "Intensidade, volume e timbre",
                    "Altura, velocidade e vibrato"
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
                    "Divisão ordenada do tempo, representada por batidas",
                    "Combinação de sons que se encaixam perfeitamente",
                    "O melhor amigo do músico",
                    "Todos os sons que possuem tempo e silêncio"
                )
            ),
            Question(
                text = "O que é o metrônomo?",
                answers = listOf(
                    "Instrumento usado para marcar o andamento na música",
                    "Nenhuma das alternativas",
                    "Uma propriedade do som",
                    "Aparelho usado para afinar instrumentos musicais"
                )
            ),
            Question(
                text = "Quais são as 4 propriedades do som?",
                answers = listOf(
                    "Timbre, Duração, Intensidade e Altura",
                    "Vibrações, ondas, intensidade e velocidade",
                    "Timbre, volume, Densidade e tempo",
                    "Ouvido, Cordas vocais, Vibração e Ritmo"
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
            ),
            Question(
                text = "O que é a propriedade de Duração de um som?",
                answers = listOf(
                    "propriedade do som ser curto ou longo",
                    "o quão alto é um som",
                    "propriedade do som ser forte ou fraco",
                    "nenhuma das alternativas"
                )
            ),
            Question(
                text = "Qual propriedade do som o faz ser Grave, Médio ou Agudo?",
                answers = listOf(
                    "Altura",
                    "Timbre",
                    "Intensidade",
                    "Duração"
                )
            ),
            Question(
                text = "O que é a propriedade de Intensidade de um som?",
                answers = listOf(
                    "Propriedade do som ser fraco ou forte",
                    "Propriedade de um som ser estridente ou inaudível",
                    "Propriedade do som ser curto ou longo",
                    "Nenhuma das alternativas"
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