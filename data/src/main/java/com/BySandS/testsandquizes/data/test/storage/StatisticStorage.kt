package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.StatisticModelDb
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel

interface StatisticStorage {
    fun getStatistic(nameSubcategory: String): StatisticModelDb

     fun updateStatistic(statisticModel: StatisticModel): Boolean
}