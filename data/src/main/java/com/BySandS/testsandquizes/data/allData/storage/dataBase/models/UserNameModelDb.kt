package com.BySandS.testsandquizes.data.allData.storage.dataBase.models

import androidx.room.ColumnInfo

class UserNameModelDb (
    @ColumnInfo(name = "name") var userName: String,
)