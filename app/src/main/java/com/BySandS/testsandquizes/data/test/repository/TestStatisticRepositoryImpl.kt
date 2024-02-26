package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import com.BySandS.testsandquizes.domain.tests.models.GetStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel
import com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository

class TestStatisticRepositoryImpl(context: Context): TestStatisticRepository {
    override fun getStatistic(idSubcategory: GetStatisticParam): StatisticModel {
        TODO("Not yet implemented")
    }

    override fun updateStatistic(statisticModel: StatisticModel): Boolean {
        TODO("Not yet implemented")
    }
}