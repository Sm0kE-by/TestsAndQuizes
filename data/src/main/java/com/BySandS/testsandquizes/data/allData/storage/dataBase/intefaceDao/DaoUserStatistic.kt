package com.BySandS.testsandquizes.data.allData.storage.dataBase.intefaceDao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.BySandS.testsandquizes.data.allData.storage.dataBase.entity.UserStatisticDbEntity
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.GameCompletionPercentageModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.QuantityOfGemsModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.UserNameModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.UserStatisticModelDb

@Dao
interface DaoUserStatistic {

    @Query("SELECT * FROM user_statistic WHERE user_statistic.id = :userId")
    fun getUserStatisticById(userId: Long): UserStatisticModelDb

    @Update
    fun saveUserStatistic(userStatistic: UserStatisticDbEntity)

    @Query("SELECT user_statistic.percent_game_completion FROM user_statistic WHERE user_statistic.id = :userId")
    fun getPercentGameCompletionByUserId(userId: Long): GameCompletionPercentageModelDb

    @Query("UPDATE user_statistic SET percent_game_completion = :percent WHERE user_statistic.id = :userId")
    fun savePercentGameCompletion(userId: Long, percent: Double)

    @Query("SELECT user_statistic.name FROM user_statistic WHERE user_statistic.id = :userId")
    fun getUserNameByUserId(userId: Long): UserNameModelDb

    @Query("UPDATE user_statistic SET name = :userName WHERE user_statistic.id = :userId")
    fun saveUserName(userId: Long, userName: String)

    @Query("SELECT user_statistic.gems FROM user_statistic WHERE user_statistic.id = :userId")
    fun getQuantityOfGemsByUserId(userId: Long): QuantityOfGemsModelDb

    @Query("UPDATE user_statistic SET gems = :gems WHERE user_statistic.id = :userId")
    fun saveQuantityOfGems(userId: Long, gems: Int)

}