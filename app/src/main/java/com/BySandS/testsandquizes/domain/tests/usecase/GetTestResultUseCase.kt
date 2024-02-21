package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.GetResultParam
import com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository

class GetTestResultUseCase(private val testResultRepository: TestResultRepository) {

    fun execute(param: GetResultParam){
        testResultRepository.getResult(param = param)
    }

}