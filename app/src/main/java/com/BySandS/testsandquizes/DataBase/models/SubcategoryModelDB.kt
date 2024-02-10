package com.BySandS.testsandquizes.DataBase.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class SubcategoryModelDB(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "category_name_ru") val typeName: String,
    @ColumnInfo(name = "subcategory_name_ru") val subcategoryName: String,
    @ColumnInfo(name = "easy") val statisticEasy: Long,
    @ColumnInfo(name = "norm") val statisticNorm: Long,
    @ColumnInfo(name = "hard") val statisticHard: Long,
)