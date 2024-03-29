package com.BySandS.testsandquizes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "subcategory",
    foreignKeys = [
        ForeignKey(
            entity = CategoryDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["category_id"]
        ),
        ForeignKey(
            entity = QuantityOfQuestionsDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["quantity_of_questions_id"]
        )
    ]
)
data class SubcategoryDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name_ru" , defaultValue = " ") val nameRu: String,
    @ColumnInfo(name = "name_eng") val nameEng: String,
    @ColumnInfo(name = "category_id") val categoryId: Long,
    @ColumnInfo(name = "quantity_of_questions_id") val quantityOfQuestions: Long,
    @ColumnInfo(name = "statistic_easy", defaultValue = "0") val statisticEasy: Int,
    @ColumnInfo(name = "statistic_norm", defaultValue = "0") val statisticNorm: Int,
    @ColumnInfo(name = "statistic_hard", defaultValue = "0") val statisticHard: Int,
    @ColumnInfo(name = "statistic_veryhard", defaultValue = "0") val statisticVeryHard: Int,
    @ColumnInfo(name = "link_to_background") val linkToBackground: String,
    @ColumnInfo(name = "link_to_icon") val linkToIcon: String
)
