package com.BySandS.testsandquizes.domain.tests.usecase


class GetTestResultUseCase(private val testResultRepository: com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository) {

    fun execute(param: com.BySandS.testsandquizes.domain.tests.models.GetResultParam){
        testResultRepository.getResult(param = param)
    }

}