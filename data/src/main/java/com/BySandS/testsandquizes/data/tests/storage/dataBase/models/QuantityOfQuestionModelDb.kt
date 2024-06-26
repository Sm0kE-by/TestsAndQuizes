package com.BySandS.testsandquizes.data.tests.storage.dataBase.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class QuantityOfQuestionModelDb(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "easy_quantity")val easyQuantity: Int,
    @ColumnInfo(name = "norm_quantity")val normQuantity: Int,
    @ColumnInfo(name = "hard_quantity")val hardQuantity: Int,
    @ColumnInfo(name = "veryhard_quantity")val veryhardQuantity: Int
)