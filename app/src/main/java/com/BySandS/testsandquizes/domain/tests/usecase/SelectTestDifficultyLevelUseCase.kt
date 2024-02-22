package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.repository.QuantityOfQuestionRepository


class SelectTestDifficultyLevelUseCase(private val quantityOfQuestionRepository: QuantityOfQuestionRepository) {

    fun execute(param: GetQuantityOfQuestionParam): QuantityOfQuestionModel {
        return quantityOfQuestionRepository.getQuantity(idSubcategory = param)
    }
}