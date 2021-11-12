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
                text = "O que são figuras musicais?",
                answers = listOf(
                    "São símbolos que representam diferentes durações de sons",
                    "É o contorno que envolve uma partitura",
                    "São traços que dividem as notas em um sistema musical",
                    "São sinais que indicam diferentes timbres na música"
                )
            ),
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
                    "Nenhuma das alternativas"
                )
            ),
            Question(
                text = "A Colcheia é representada por qual número?",
                answers = listOf(
                    "8",
                    "2",
                    "1",
                    "4"
                )
            ),
            Question(
                text = "A Semínima é representada por qual número?",
                answers = listOf(
                    "4",
                    "6",
                    "8",
                    "16"
                )
            ),
            Question(
                text = "Qual propriedade do som permite um som ser grave ou agudo?",
                answers = listOf(
                    "Altura",
                    "Timbre",
                    "Duração",
                    "Intensidade"
                )
            ),
            Question(
                text = "O que faz um som ser agudo?",
                answers = listOf(
                    "Uma alta frequência de ondas sonoras",
                    "A capacidade de alguém gritar fino",
                    "Uma baixa frequência de ondas sonoras",
                    "Um falsete de um cantor"
                )
            ),
            Question(
                text = "Uma baixa frequência de ondas sonoras é considerado um som:",
                answers = listOf(
                    "Grave",
                    "Fraco",
                    "Irritante",
                    "Agudo"
                )
            )
        )

    }

    fun getModuleThreeQuestions() :MutableList<Question> {
        return mutableListOf(
            Question(
                text = "O que é um compasso?",
                answers = listOf(
                    "É o agrupamento de tempos",
                    "É um instrumento usado para desenhar formas redondas",
                    "Separação de versos",
                    "O espaço entre figuras musicais"
                )
            ),
            Question(
                text = "\"O compasso que agrupa 4 tempos é o ________; o que agrupa 2 tempos é o ______; e o que agrupa 3 tempos é o ______.\"\n" +
                        "Qual das alternativas abaixo completam, respectivamente, a afirmação acima?",
                answers = listOf(
                    "Quaternário; binário; ternário",
                    "Quaternário; duplo; ternário",
                    "Quádruplo; binário; terciário",
                    "Quadrante; bípede; terceiro"
                )
            ),
            Question(
                text = "O que separa compassos numa partitura é uma linha vertical, chamada:",
                answers = listOf(
                    "Barra de compasso",
                    "Barra dupla",
                    "Linha de compasso",
                    "Ritornello"
                )
            ),
            Question(
                text = "Pra que serve uma Barra final?",
                answers = listOf(
                    "Para indicar a conclusão ou finalização de uma partitura",
                    "Para indicar o fim de uma nota",
                    "Para mostrar onde respiramos na música",
                    "Indica separação entre verso e refrão"
                )
            ),
            Question(
                text = "Para que servem os Sinais de Ritornello?",
                answers = listOf(
                    "Para repetir o que há entre dois sinais de Ritornello",
                    "Para retornar ao início de uma partitura",
                    "É onde vamos reiniciar a execução de uma música",
                    "Significa importância do compasso que está entre dois sinais de Ritornello"
                )
            )
        )
    }
}