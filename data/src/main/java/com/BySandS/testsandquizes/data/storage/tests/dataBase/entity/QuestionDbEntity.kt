package com.BySandS.testsandquizes.data.storage.tests.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "question",
    foreignKeys = [
        ForeignKey(
            entity = DifficultyDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["difficulty_id"]
        ),
        ForeignKey(
            entity = SubcategoryDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["subcategory_id"]
        )
    ]
)
data class QuestionDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "difficulty_id") val difficultyId: Long,
    @ColumnInfo(name = "subcategory_id", defaultValue = "1") val subcategoryId:  Long,
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
