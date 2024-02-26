package com.BySandS.testsandquizes.data.test.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.BySandS.testsandquizes.data.test.models.StatisticModelDb

@Dao
interface TestStatisticDao {

    @Query("SELECT * FROM statistic_subcategory WHERE name_subcategory = :nameSubcategory")
    fun getStatistic(nameSubcategory: String): StatisticModelDb

//        @Update
//    fun saveStatistic(statisticModel: StatisticModelDb): Boolean
}