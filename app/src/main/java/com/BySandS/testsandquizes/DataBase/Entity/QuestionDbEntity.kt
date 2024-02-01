package com.BySandS.testsandquizes.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "result",
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
        ),
        ForeignKey(
            entity = QuestionTextDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["question_text_id"]
        ),
    ]
)
data class QuestionDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "difficulty_id") val resultText: Long,
    @ColumnInfo(name = "subcategory_id") val testResult:  Long,
    @ColumnInfo(name = "question_text_id") val difficulty: Long,
)
