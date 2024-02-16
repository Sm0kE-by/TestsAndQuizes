package com.BySandS.testsandquizes.data.test.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class ResultModelDb (
    @ColumnInfo(name = "result_text_id") val id: Long,
    @ColumnInfo(name = "result_text_33") val resultText33: String,
    @ColumnInfo(name = "result_text_66") val resultText66: String,
    @ColumnInfo(name = "result_text_99") val resultText99: String,
    @ColumnInfo(name = "result_text_100") val resultText100: String,
)