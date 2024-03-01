package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetResultParam
import com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository


class GetTestResultUseCase(private val testResultRepository: TestResultRepository) {

    fun execute(param: GetResultParam): ResultTestModel{
       return testResultRepository.getResult(param = param)
    }

}