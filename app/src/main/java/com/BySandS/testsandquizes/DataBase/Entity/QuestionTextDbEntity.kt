package com.BySandS.testsandquizes.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_text")
data class QuestionTextDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "question_text_ru") val questionTextRu: String,
    @ColumnInfo(name = "correct_answer_ru") val correctAnswerRu: String,
    @ColumnInfo(name = "incorrect_answer_1_ru") val incorrectAnswer1Ru: String,
    @ColumnInfo(name = "incorrect_answer_2_ru") val incorrectAnswer2Ru: String,
    @ColumnInfo(name = "incorrect_answer_3_ru") val incorrectAnswer3Ru: String,
    @ColumnInfo(name = "question_text_eng") val questionTextEng: String,
    @ColumnInfo(name = "correct_answer_eng") val correctAnswerEng: String,
    @ColumnInfo(name = "incorrect_answer_1_eng") val incorrectAnswer1Eng: String,
    @ColumnInfo(name = "incorrect_answer_2_eng") val incorrectAnswer2Eng: String,
    @ColumnInfo(name = "incorrect_answer_3_eng") val incorrectAnswer3Eng: String,
)
