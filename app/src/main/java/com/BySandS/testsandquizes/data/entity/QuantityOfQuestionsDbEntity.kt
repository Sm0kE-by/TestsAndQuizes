package com.BySandS.testsandquizes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quantity_of_questions")
data class QuantityOfQuestionsDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "easy_quantity") val easyQuantity: Int,
    @ColumnInfo(name = "norm_quantity") val normQuantity: Int,
    @ColumnInfo(name = "hard_quantity") val hardQuantity: Int,
)
