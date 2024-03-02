package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.StatisticModel
import com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository


class SaveTestStatisticUseCase(private val testStatisticRepository: TestStatisticRepository) {

    fun execute(param: StatisticModel) {
        return testStatisticRepository.updateStatistic(statisticModel = param)
    }

}