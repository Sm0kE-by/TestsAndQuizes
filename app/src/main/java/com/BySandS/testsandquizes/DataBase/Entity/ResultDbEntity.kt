package com.BySandS.testsandquizes.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.BySandS.testsandquizes.DataBase.Entity.Result

@Entity(tableName = "result",
    foreignKeys = [
        ForeignKey(
            entity = ResultText::class,
            parentColumns = ["id"],
            childColumns = ["result_text_id"]
        ),
        ForeignKey(
            entity = TestResults::class,
            parentColumns = ["id"],
            childColumns = ["test_result_id"]
        ),
        ForeignKey(
            entity = Difficulty::class,
            parentColumns = ["id"],
            childColumns = ["difficulty_id"]
        ),
    ]
)
data class Result(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "result_text_id") val resultText: Long,
    @ColumnInfo(name = "test_result_id") val testResult:  Long,
    @ColumnInfo(name = "difficulty_id") val difficulty: Long,
)
