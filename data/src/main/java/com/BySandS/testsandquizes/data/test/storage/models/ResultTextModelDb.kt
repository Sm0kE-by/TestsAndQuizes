package com.BySandS.testsandquizes.data.test.storage.models

import androidx.room.ColumnInfo

data class ResultTextModelDb (
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "result_text_33_ru") val resultText33: String,
    @ColumnInfo(name = "result_text_66_ru") val resultText66: String,
    @ColumnInfo(name = "result_text_99_ru") val resultText99: String,
    @ColumnInfo(name = "result_text_100_ru") val resultText100: String,
)