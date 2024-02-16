package com.BySandS.testsandquizes.domain.tests.models


data class QuestionModel(
    val id: Long,
    val questionText: String,
    val correctAnswer: String,
    val incorrectAnswer1: String,
    val incorrectAnswer2: String,
    val incorrectAnswer3: String,
)
