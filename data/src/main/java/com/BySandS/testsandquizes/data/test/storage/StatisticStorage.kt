package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.entity.StatisticsDbEntity
import com.BySandS.testsandquizes.data.test.storage.models.StatisticModelDb

interface StatisticStorage {
    fun getStatistic(nameSubcategory: String): StatisticModelDb
    fun updateStatistic(statisticModel: StatisticsDbEntity)
}