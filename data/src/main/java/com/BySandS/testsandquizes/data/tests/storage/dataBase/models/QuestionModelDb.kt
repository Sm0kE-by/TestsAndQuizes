package com.BySandS.testsandquizes.data.tests.storage.dataBase.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class QuestionModelDb(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "difficulty_id") val difficultyId: Long,
    @ColumnInfo(name = "subcategory_id") val subcategoryId:  Long,
    @ColumnInfo(name = "text_ru") val textRu: String,
    @ColumnInfo(name = "correct_answer_ru") val correctAnswerRu: String,
    @ColumnInfo(name = "incorrect_answer_1_ru") val incorrectAnswer1Ru: String,
    @ColumnInfo(name = "incorrect_answer_2_ru") val incorrectAnswer2Ru: String,
    @ColumnInfo(name = "incorrect_answer_3_ru") val incorrectAnswer3Ru: String,
    @ColumnInfo(name = "correct_answer_eng") val correctAnswerEng: String,
    @ColumnInfo(name = "incorrect_answer_1_eng") val incorrectAnswer1Eng: String,
    @ColumnInfo(name = "incorrect_answer_2_eng") val incorrectAnswer2Eng: String,
    @ColumnInfo(name = "incorrect_answer_3_eng") val incorrectAnswer3Eng: String
)
