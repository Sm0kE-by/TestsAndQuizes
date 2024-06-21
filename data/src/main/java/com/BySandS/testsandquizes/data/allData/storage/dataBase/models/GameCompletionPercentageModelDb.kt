package com.BySandS.testsandquizes.data.allData.storage.dataBase.models

import androidx.room.ColumnInfo

class GameCompletionPercentageModelDb (
    @ColumnInfo(name = "percent_game_completion") var percentGameCompletion: Double,
)