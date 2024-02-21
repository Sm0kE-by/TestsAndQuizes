package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.GetStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel
import com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository

class GetTestStatisticUseCase(private val testStatisticRepository: TestStatisticRepository) {

    fun execute(param: GetStatisticParam):StatisticModel {
        return testStatisticRepository.getStatistic(idSubcategory = param)
    }

}