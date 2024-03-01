package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import com.BySandS.testsandquizes.data.test.storage.dao.DaoStatisticStorage
import com.BySandS.testsandquizes.data.test.storage.models.StatisticModelDb
import com.BySandS.testsandquizes.domain.tests.models.param.GetStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel
import com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository

class TestStatisticRepositoryImpl(private val daoStatisticStorage: DaoStatisticStorage) :
    TestStatisticRepository {
    override fun getStatistic(param: GetStatisticParam): StatisticModel {
        return mapToDomain(daoStatisticStorage.getStatistic(nameSubcategory = mapToStorage(param = param)))
    }

    override fun updateStatistic(statisticModel: StatisticModel): Boolean {
        TODO("Not yet implemented")
    }

    private fun mapToDomain(statisticModelDb: StatisticModelDb): StatisticModel {
        return StatisticModel(
            id = statisticModelDb.id,
            nameSubcategory = statisticModelDb.nameSubcategory,
            easy = statisticModelDb.easy,
            norm = statisticModelDb.norm,
            hard = statisticModelDb.hard
        )
    }

    private fun mapToStorage(param: GetStatisticParam): String {
        return param.nameSubcategory
    }
}