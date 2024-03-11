package com.BySandS.testsandquizes.data.entity

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
    @ColumnInfo(name = "text_ru", defaultValue = " ") val textRu: String,
    @ColumnInfo(name = "correct_answer_ru", defaultValue = " ") val correctAnswerRu: String,
    @ColumnInfo(name = "incorrect_answer_1_ru", defaultValue = " ") val incorrectAnswer1Ru: String,
    @ColumnInfo(name = "incorrect_answer_2_ru", defaultValue = " ") val incorrectAnswer2Ru: String,
    @ColumnInfo(name = "incorrect_answer_3_ru", defaultValue = " ") val incorrectAnswer3Ru: String,
    @ColumnInfo(name = "correct_answer_eng", defaultValue = " ") val correctAnswerEng: String,
    @ColumnInfo(name = "incorrect_answer_1_eng", defaultValue = " ") val incorrectAnswer1Eng: String,
    @ColumnInfo(name = "incorrect_answer_2_eng", defaultValue = " ") val incorrectAnswer2Eng: String,
    @ColumnInfo(name = "incorrect_answer_3_eng", defaultValue = " ") val incorrectAnswer3Eng: String
)
