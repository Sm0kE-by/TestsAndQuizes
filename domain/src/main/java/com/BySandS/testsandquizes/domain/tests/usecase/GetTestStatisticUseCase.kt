package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.param.GetStatisticParam


class GetTestStatisticUseCase(private val testStatisticRepository: com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository) {

    fun execute(param: GetStatisticParam): com.BySandS.testsandquizes.domain.tests.models.StatisticModel {
        return testStatisticRepository.getStatistic(idSubcategory = param)
    }

}