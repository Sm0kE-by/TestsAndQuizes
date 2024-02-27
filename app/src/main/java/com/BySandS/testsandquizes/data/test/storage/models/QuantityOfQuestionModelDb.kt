package com.BySandS.testsandquizes.data.test.storage.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class QuantityOfQuestionModelDb(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "easy_quantity")val easyQuantity: Int,
    @ColumnInfo(name = "norm_quantity")val normQuantity: Int,
    @ColumnInfo(name = "hard_quantity")val hardQuantity: Int
)