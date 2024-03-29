package com.BySandS.testsandquizes.data.test.storage.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class SubcategoryModelDb(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name_ru") val nameRu: String,
    @ColumnInfo(name = "name_eng") val nameEng: String,
    @ColumnInfo(name = "category_id") val categoryId: Long,
    @ColumnInfo(name = "quantity_of_questions_id") val quantityOfQuestions: Long,
    @ColumnInfo(name = "statistic_easy") val statisticEasy: Int,
    @ColumnInfo(name = "statistic_norm") val statisticNorm: Int,
    @ColumnInfo(name = "statistic_hard") val statisticHard: Int,
    @ColumnInfo(name = "statistic_veryhard") val statisticVeryHard: Int,
    @ColumnInfo(name = "link_to_background") val linkToBackground: String,
    @ColumnInfo(name = "link_to_icon") val linkToIcon: String
)