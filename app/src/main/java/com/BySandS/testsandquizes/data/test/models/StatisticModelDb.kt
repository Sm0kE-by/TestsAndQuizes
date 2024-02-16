package com.BySandS.testsandquizes.data.test.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class StatisticModelDb(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name_subcategory") val nameSubcategory: String,
    @ColumnInfo(name = "easy") val easy: Int,
    @ColumnInfo(name = "norm") val norm: Int,
    @ColumnInfo(name = "hard") val hard: Int,
)
