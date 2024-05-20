package com.BySandS.testsandquizes.data.allData.storage.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "avatar_type")

class AvatarTypeDbEntity (
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "avatar_type_name_ru") val categoryNameRu: String,
    @ColumnInfo(name = "avatar_type_name_eng") val categoryNameEng: String,
)