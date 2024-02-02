package com.BySandS.testsandquizes.DataBase.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class SubcategoryModel(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "subcategory_name") val subcategoryName: String,
    @ColumnInfo(name = "statistic_id") val statisticId: Long,
    @ColumnInfo(name = "category_id") val categoryId:  Long,
    @ColumnInfo(name = "quantity_of_questions_id") val quantityOfQuestionsId: Long,
    @ColumnInfo(name = "test_result_id") val testResultId: Long,
)