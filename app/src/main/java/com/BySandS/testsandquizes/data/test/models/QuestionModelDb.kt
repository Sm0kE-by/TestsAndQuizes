package com.BySandS.testsandquizes.data.test.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class QuestionModelDb(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "question_text_ru") val questionTextRu: String,
    @ColumnInfo(name = "correct_answer_ru") val correctAnswerRu: String,
    @ColumnInfo(name = "incorrect_answer_1_ru") val incorrectAnswer1Ru: String,
    @ColumnInfo(name = "incorrect_answer_2_ru") val incorrectAnswer2Ru: String,
    @ColumnInfo(name = "incorrect_answer_3_ru") val incorrectAnswer3Ru: String,
)
