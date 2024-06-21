package com.BySandS.testsandquizes.data.allData.storage.storageInterface

import com.BySandS.testsandquizes.data.allData.storage.dataBase.entity.UserStatisticDbEntity
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.GameCompletionPercentageModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.QuantityOfGemsModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.UserNameModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.UserStatisticModelDb

interface UserStatisticStorage {

    fun getUserStatisticById(userId: Long): UserStatisticModelDb
    fun saveUserStatistic(userStatistic: UserStatisticDbEntity)
    fun getPercentGameCompletionByUserId(userId: Long): GameCompletionPercentageModelDb
    fun savePercentGameCompletion(userId: Long, percent: Double)
    fun getUserNameByUserId(userId: Long): UserNameModelDb
    fun saveUserName(userId: Long, userName: String)
    fun getQuantityOfGemsByUserId(userId: Long): QuantityOfGemsModelDb
    fun saveQuantityOfGems(userId: Long, gems: Int)


}