package com.BySandS.testsandquizes.domain.tests.repository


interface TestStatisticRepository {

   fun getStatistic(idSubcategory: com.BySandS.testsandquizes.domain.tests.models.GetStatisticParam): com.BySandS.testsandquizes.domain.tests.models.StatisticModel
   fun updateStatistic(statisticModel: com.BySandS.testsandquizes.domain.tests.models.StatisticModel): Boolean

}