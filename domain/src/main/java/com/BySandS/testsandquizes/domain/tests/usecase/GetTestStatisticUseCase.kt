package com.BySandS.testsandquizes.domain.tests.usecase


class GetTestStatisticUseCase(private val testStatisticRepository: com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository) {

    fun execute(param: com.BySandS.testsandquizes.domain.tests.models.GetStatisticParam): com.BySandS.testsandquizes.domain.tests.models.StatisticModel {
        return testStatisticRepository.getStatistic(idSubcategory = param)
    }

}