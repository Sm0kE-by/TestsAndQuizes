package com.BySandS.testsandquizes.data.storage.tests.dataBase.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class SubcategoryModelForSubcategoryFragmentDb(
    @PrimaryKey val id: Long,
    val name: String,
    @ColumnInfo(name = "statistic_easy") val statisticEasy: Int,
    @ColumnInfo(name = "statistic_norm") val statisticNorm: Int,
    @ColumnInfo(name = "statistic_hard") val statisticHard: Int,
    @ColumnInfo(name = "statistic_veryhard") val statisticVeryHard: Int,
    @ColumnInfo(name = "link_to_icon") val linkToIcon: String
)