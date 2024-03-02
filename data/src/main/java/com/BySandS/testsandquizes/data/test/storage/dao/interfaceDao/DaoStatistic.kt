package com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.BySandS.testsandquizes.data.entity.StatisticsDbEntity
import com.BySandS.testsandquizes.data.test.storage.models.StatisticModelDb

@Dao
interface DaoStatistic {

    @Query("SELECT * FROM statistic_subcategory WHERE name_subcategory = :nameSubcategory")
    fun getStatistic(nameSubcategory: String): StatisticModelDb

    @Update
    fun saveStatistic(statisticModel: StatisticsDbEntity)
}