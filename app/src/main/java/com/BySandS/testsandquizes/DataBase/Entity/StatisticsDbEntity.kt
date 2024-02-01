package com.BySandS.testsandquizes.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "statistic_subcategory")
data class Statistics(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "easy") val easy: Int,
    @ColumnInfo(name = "norm") val norm: Int,
    @ColumnInfo(name = "hard") val hard: Int,
)
