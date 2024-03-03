package com.BySandS.testsandquizes.data.test.repository

import android.util.Log
import com.BySandS.testsandquizes.data.entity.StatisticsDbEntity
import com.BySandS.testsandquizes.data.test.storage.StatisticStorage
import com.BySandS.testsandquizes.data.test.storage.models.StatisticModelDb
import com.BySandS.testsandquizes.domain.tests.models.param.GetStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel
import com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository

private const val TAG = "AAA"
class TestStatisticRepositoryImpl(private val statisticStorage: StatisticStorage) :
    TestStatisticRepository {
    override fun getStatistic(param: GetStatisticParam): StatisticModel {
        return mapToDomain(statisticStorage.getStatistic(nameSubcategory = mapToStorageGetStatistic(param = param)))
    }

    override fun updateStatistic(statisticModel: StatisticModel) {
        return statisticStorage.updateStatistic(mapToStorageStatisticModelDb(statisticModel = statisticModel))
    }

    private fun mapToDomain(statisticModelDb: StatisticModelDb): StatisticModel {
        Log.e(TAG, "$statisticModelDb")
        return StatisticModel(
            id = statisticModelDb.id,
            nameSubcategory = statisticModelDb.nameSubcategory,
            easy = statisticModelDb.easy,
            norm = statisticModelDb.norm,
            hard = statisticModelDb.hard
        )
    }

    private fun mapToStorageGetStatistic(param: GetStatisticParam): String {
        return param.nameSubcategory
    }
    private fun mapToStorageStatisticModelDb(statisticModel: StatisticModel): StatisticsDbEntity {
        return StatisticsDbEntity(
            id = statisticModel.id,
            nameSubcategory = statisticModel.nameSubcategory,
            easy = statisticModel.easy,
            norm = statisticModel.norm,
            hard = statisticModel.hard
        )
    }
}