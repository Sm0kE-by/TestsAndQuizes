package com.BySandS.testsandquizes.data.allData.storage.dataBase.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class UserStatisticModelDb(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val userName: String,
    @ColumnInfo(name = "percent_game_completion") val percentGameCompletion: Double,
    @ColumnInfo(name = "prestige") val prestige: Int,
    @ColumnInfo(name = "gems") val gems: Int,
)