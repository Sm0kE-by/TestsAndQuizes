package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.StatisticModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetStatisticParam


interface TestStatisticRepository {

   fun getStatistic(param: GetStatisticParam): StatisticModel
   fun updateStatistic(statisticModel: StatisticModel): Boolean

}