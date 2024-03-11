package com.BySandS.testsandquizes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "difficulty_level")
data class DifficultyDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name_level_ru") val nameLevelRu: String,
    @ColumnInfo(name = "name_level_eng", defaultValue = " ") val nameLevelEng: String,
)
