package com.BySandS.testsandquizes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "statistic_subcategory")
data class StatisticsDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name_subcategory") val nameSubcategory: String,
    @ColumnInfo(name = "easy") val easy: Int,
    @ColumnInfo(name = "norm") val norm: Int,
    @ColumnInfo(name = "hard") val hard: Int,
)
