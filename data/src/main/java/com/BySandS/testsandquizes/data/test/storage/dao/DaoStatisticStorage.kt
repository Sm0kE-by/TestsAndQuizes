package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.StatisticStorage
import com.BySandS.testsandquizes.data.test.storage.models.StatisticModelDb
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel

class DaoStatisticStorage(context: Context): StatisticStorage {

    private val testsDaoRu = AppDatabase.getInstance(context).testStatistic()
    override fun getStatistic(nameSubcategory: String): StatisticModelDb {
       return testsDaoRu.getStatistic(nameSubcategory = nameSubcategory)
    }

    override fun updateStatistic(statisticModel: StatisticModel): Boolean {
        TODO("Not yet implemented")
    }
}