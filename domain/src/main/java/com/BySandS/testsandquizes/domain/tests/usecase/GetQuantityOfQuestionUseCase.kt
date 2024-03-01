package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.repository.QuantityOfQuestionRepository


class GetQuantityOfQuestionUseCase(private val quantityOfQuestionRepository: QuantityOfQuestionRepository) {

    fun execute(param: GetQuantityOfQuestionParam): QuantityOfQuestionModel {
        return quantityOfQuestionRepository.getQuantity(idQuantity = param)
    }
}