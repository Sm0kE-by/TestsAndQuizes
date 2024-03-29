package com.BySandS.testsandquizes.domain.tests.usecase.mainActivity

import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.repository.TestQuantityOfQuestionRepository


class GetQuantityOfQuestionUseCase(private val testQuantityOfQuestionRepository: TestQuantityOfQuestionRepository) {

    fun execute(param: GetQuantityOfQuestionParam): QuantityOfQuestionModel {
        return testQuantityOfQuestionRepository.getQuantity(param = param)
    }
}