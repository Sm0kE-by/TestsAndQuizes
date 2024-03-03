package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.entity.StatisticsDbEntity
import com.BySandS.testsandquizes.data.test.storage.StatisticStorage
import com.BySandS.testsandquizes.data.test.storage.models.StatisticModelDb

class DaoStatisticStorageImpl(context: Context): StatisticStorage {

    private val testsDaoRu = AppDatabase.getInstance(context).statisticDao()
    override fun getStatistic(nameSubcategory: String): StatisticModelDb {
       return testsDaoRu.getStatistic(nameSubcategory = nameSubcategory)
    }

    override fun updateStatistic(statisticModel: StatisticsDbEntity) {
       return testsDaoRu.saveStatistic(statisticModel = statisticModel)
    }
}