package com.BySandS.testsandquizes.models.mainActivityModels

import com.BySandS.testsandquizes.DataBase.Entity.Question

class DifficultyNameModel(
    val difficulty: String,
    val quantityQuestion: String,
    val bestResult: String,
    val easy: String,
    val norm: String,
    val hard: String,
)