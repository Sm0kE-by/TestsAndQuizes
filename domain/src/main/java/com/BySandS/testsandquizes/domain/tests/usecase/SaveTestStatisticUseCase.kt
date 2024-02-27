package com.BySandS.testsandquizes.domain.tests.usecase


class SaveTestStatisticUseCase(private val testStatisticRepository: com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository) {

    fun execute(param: com.BySandS.testsandquizes.domain.tests.models.StatisticModel): Boolean {
        return testStatisticRepository.updateStatistic(statisticModel = param)
    }

}