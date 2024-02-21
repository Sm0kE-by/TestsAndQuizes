package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.GetStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel

interface TestStatisticRepository {

   fun getStatistic(idSubcategory: GetStatisticParam): StatisticModel
   fun updateStatistic(statisticModel: StatisticModel): Boolean

}