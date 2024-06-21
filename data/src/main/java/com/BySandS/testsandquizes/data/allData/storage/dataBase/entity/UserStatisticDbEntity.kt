package com.BySandS.testsandquizes.data.allData.storage.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_statistic")

class UserStatisticDbEntity (
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val userName: String,
    @ColumnInfo(name = "percent_game_completion") val percentGameCompletion: Double,
    @ColumnInfo(name = "prestige") val prestige: Int,
    @ColumnInfo(name = "gems") val gems: Int,
)