package com.BySandS.testsandquizes.DataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "difficulty_level")
data class DifficultyDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name_level") val easyLevel: String,
)
