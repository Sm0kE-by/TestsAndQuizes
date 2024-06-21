package com.BySandS.testsandquizes.data.allData.storage.dataBase.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.allData.storage.dataBase.entity.UserStatisticDbEntity
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.GameCompletionPercentageModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.QuantityOfGemsModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.UserNameModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.UserStatisticModelDb
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.UserStatisticStorage
import com.BySandS.testsandquizes.data.tests.storage.dataBase.AppDatabase

class UserStatisticStorageImpl(context: Context): UserStatisticStorage {

    private val userStatisticDao = AppDatabase.getInstance(context).userStatisticDao()
    override fun getUserStatisticById(userId: Long): UserStatisticModelDb {
        return userStatisticDao.getUserStatisticById(userId = userId)
    }

    override fun saveUserStatistic(userStatistic: UserStatisticDbEntity) {
        userStatisticDao.saveUserStatistic(userStatistic = userStatistic)
    }

    override fun getPercentGameCompletionByUserId(userId: Long): GameCompletionPercentageModelDb {
        return userStatisticDao.getPercentGameCompletionByUserId(userId = userId)
    }

    override fun savePercentGameCompletion(userId: Long, percent: Double) {
        userStatisticDao.savePercentGameCompletion(userId = userId, percent = percent)
    }

    override fun getUserNameByUserId(userId: Long): UserNameModelDb {
      return userStatisticDao.getUserNameByUserId(userId = userId)
    }

    override fun saveUserName(userId: Long, userName: String) {
       userStatisticDao.saveUserName(userId = userId, userName = userName)
    }

    override fun getQuantityOfGemsByUserId(userId: Long): QuantityOfGemsModelDb {
        return userStatisticDao.getQuantityOfGemsByUserId(userId = userId)
    }

    override fun saveQuantityOfGems(userId: Long, gems: Int) {
        userStatisticDao.saveQuantityOfGems(userId = userId, gems = gems)
    }
}