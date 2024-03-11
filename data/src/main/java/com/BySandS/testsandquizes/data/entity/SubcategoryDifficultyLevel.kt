package com.BySandS.testsandquizes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "subcategory_difficulty_level",
    foreignKeys = [
        ForeignKey(
            entity = SubcategoryDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["subcategory_id"]
        ),
        ForeignKey(
            entity = DifficultyDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["difficulty_id"]
        )
    ]
)
data class SubcategoryDifficultyLevel(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "subcategory_id", defaultValue = "1") val subcategoryId: Long,
    @ColumnInfo(name = "difficulty_id") val difficultyId: Long
)