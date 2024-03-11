package com.BySandS.testsandquizes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "result",
    foreignKeys = [
        ForeignKey(
            entity = DifficultyDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["difficulty_id"]
        ),
        ForeignKey(
            entity = SubcategoryDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["subcategory_id"]
        )
    ]
)
data class ResultDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "difficulty_id") val difficultyId: Long,
    @ColumnInfo(name = "subcategory_id", defaultValue = "1") val subcategoryId:  Long,
    @ColumnInfo(name = "result_text_33_ru", defaultValue = " ") val resultText33Ru:  String,
    @ColumnInfo(name = "result_text_66_ru", defaultValue = " ") val resultText66Ru:  String,
    @ColumnInfo(name = "result_text_99_ru", defaultValue = " ") val resultText99Ru:  String,
    @ColumnInfo(name = "result_text_100_ru", defaultValue = " ") val resultText100Ru:  String,
    @ColumnInfo(name = "result_text_33_eng", defaultValue = " ") val resultText33Eng:  String,
    @ColumnInfo(name = "result_text_66_eng", defaultValue = " ") val resultText66Eng:  String,
    @ColumnInfo(name = "result_text_99_eng", defaultValue = " ") val resultText99Eng:  String,
    @ColumnInfo(name = "result_text_100_eng", defaultValue = " ") val resultText100Eng:  String,
)
