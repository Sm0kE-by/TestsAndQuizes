package com.BySandS.testsandquizes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_result")
data class ResultsTestDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "test_result_name_ru") val testResultNameRu: String,
    @ColumnInfo(name = "test_result_name_eng") val testResultNameEng: String,
)