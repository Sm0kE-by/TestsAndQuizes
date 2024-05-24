package com.BySandS.testsandquizes.data.allData.storage.dataBase.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class AvatarModelDb (
    @PrimaryKey val id: Long,
    val name: String,
    val type: String,
    @ColumnInfo(name = "description")val description: String,
    @ColumnInfo(name = "open")val open: Boolean,
    @ColumnInfo(name = "avatar_icon")val avatarIcon: String
)