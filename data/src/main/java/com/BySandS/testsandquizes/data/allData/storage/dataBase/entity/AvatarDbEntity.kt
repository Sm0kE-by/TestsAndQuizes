package com.BySandS.testsandquizes.data.allData.storage.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "avatar",
    foreignKeys = [
        ForeignKey(
            entity = AvatarTypeDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["avatar_type_id"]
        )
    ]
)

class AvatarDbEntity (
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name_ru" ) val nameRu: String,
    @ColumnInfo(name = "name_eng") val nameEng: String,
    @ColumnInfo(name = "avatar_type_id") val avatarTypeId: Long,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "open") val open: Boolean,
    @ColumnInfo(name = "avatar_icon") val avatarIcon: String,
)