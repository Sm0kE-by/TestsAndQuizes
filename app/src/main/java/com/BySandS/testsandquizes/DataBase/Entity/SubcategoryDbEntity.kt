package com.BySandS.testsandquizes.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "subcategory",
    foreignKeys = [
        ForeignKey(
            entity = Statistics::class,
            parentColumns = ["id"],
            childColumns = ["statistic_id"]
        ),
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["category_id"]
        ),
        ForeignKey(
            entity = QuantityOfQuestions::class,
            parentColumns = ["id"],
            childColumns = ["quantity_of_questions_id"]
        ),
        ForeignKey(
            entity = TestResults::class,
            parentColumns = ["id"],
            childColumns = ["test_result_id"]
        ),
    ]
)
data class Subcategory(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "subcategory_name_ru") val subcategoryNameRu: String,
    @ColumnInfo(name = "subcategory_name_eng") val subcategoryNameEng: String,
    @ColumnInfo(name = "statistic_id") val statisticId: Long,
    @ColumnInfo(name = "category_id") val categoryId:  Long,
    @ColumnInfo(name = "quantity_of_questions_id") val quantityOfQuestionsId: Long,
    @ColumnInfo(name = "test_result_id") val testResultId: Long,
)
