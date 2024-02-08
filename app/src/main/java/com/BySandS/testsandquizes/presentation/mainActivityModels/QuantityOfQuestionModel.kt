package com.BySandS.testsandquizes.presentation.mainActivityModels

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class QuantityOfQuestionModel(
    val easyQuantity: Int,
    val normQuantity: Int,
    val hardQuantity: Int
)