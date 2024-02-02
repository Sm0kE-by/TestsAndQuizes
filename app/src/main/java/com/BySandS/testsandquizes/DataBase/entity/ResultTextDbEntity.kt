package com.BySandS.testsandquizes.DataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_text")
data class ResultTextDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "result_text_33_ru") val resultText33Ru: String,
    @ColumnInfo(name = "result_text_66_ru") val resultText66Ru: String,
    @ColumnInfo(name = "result_text_99_ru") val resultText99Ru: String,
    @ColumnInfo(name = "result_text_100_ru") val resultText100Ru: String,
    @ColumnInfo(name = "result_text_33_eng") val resultText33Eng: String,
    @ColumnInfo(name = "result_text_66_eng") val resultText66Eng: String,
    @ColumnInfo(name = "result_text_99_eng") val resultText99Eng: String,
    @ColumnInfo(name = "result_text_100_eng") val resultText100Eng: String,
)
