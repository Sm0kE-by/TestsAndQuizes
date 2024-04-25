package com.BySandS.testsandquizes.data.storage.tests.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")

data class CategoryDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "category_name_ru") val categoryNameRu: String,
    @ColumnInfo(name = "category_name_eng") val categoryNameEng: String,
)
