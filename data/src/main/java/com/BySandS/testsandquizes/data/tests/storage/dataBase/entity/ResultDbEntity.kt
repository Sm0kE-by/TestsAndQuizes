package com.BySandS.testsandquizes.data.tests.storage.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "result",
    foreignKeys = [
        ForeignKey(
            entity = DifficultyDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["difficulty_level_id"]
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
    @ColumnInfo(name = "difficulty_level_id") val difficultyId: Long,
    @ColumnInfo(name = "subcategory_id") val subcategoryId:  Long,
    @ColumnInfo(name = "result_text_33_ru") val resultText33Ru:  String,
    @ColumnInfo(name = "result_text_66_ru") val resultText66Ru:  String,
    @ColumnInfo(name = "result_text_99_ru") val resultText99Ru:  String,
    @ColumnInfo(name = "result_text_100_ru") val resultText100Ru:  String,
    @ColumnInfo(name = "result_text_33_eng") val resultText33Eng:  String,
    @ColumnInfo(name = "result_text_66_eng") val resultText66Eng:  String,
    @ColumnInfo(name = "result_text_99_eng") val resultText99Eng:  String,
    @ColumnInfo(name = "result_text_100_eng") val resultText100Eng:  String,
)
