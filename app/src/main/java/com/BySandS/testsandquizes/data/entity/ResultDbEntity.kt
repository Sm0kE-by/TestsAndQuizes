package com.BySandS.testsandquizes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "result",
    foreignKeys = [
        ForeignKey(
            entity = ResultTextDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["result_text_id"]
        ),
        ForeignKey(
            entity = ResultsTestDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["test_result_id"]
        ),
        ForeignKey(
            entity = DifficultyDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["difficulty_id"]
        ),
    ]
)
data class ResultDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "result_text_id") val resultText: Long,
    @ColumnInfo(name = "test_result_id") val testResult:  Long,
    @ColumnInfo(name = "difficulty_id") val difficulty: Long,
)
