package com.BySandS.testsandquizes.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "difficulty_level")
data class DifficultyDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "easy_level") val easyLevel: Int,
    @ColumnInfo(name = "norm_level") val normLevel: Int,
    @ColumnInfo(name = "hard_level") val hardLevel: Int,
)
