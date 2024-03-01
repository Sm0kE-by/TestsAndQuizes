package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.param.GetStatisticParam


interface TestStatisticRepository {

   fun getStatistic(idSubcategory: GetStatisticParam): com.BySandS.testsandquizes.domain.tests.models.StatisticModel
   fun updateStatistic(statisticModel: com.BySandS.testsandquizes.domain.tests.models.StatisticModel): Boolean

}