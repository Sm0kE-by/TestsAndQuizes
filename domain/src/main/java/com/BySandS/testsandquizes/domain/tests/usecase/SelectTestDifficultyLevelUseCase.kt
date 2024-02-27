package com.BySandS.testsandquizes.domain.tests.usecase



class SelectTestDifficultyLevelUseCase(private val quantityOfQuestionRepository: com.BySandS.testsandquizes.domain.tests.repository.QuantityOfQuestionRepository) {

    fun execute(param: com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam): com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel {
        return quantityOfQuestionRepository.getQuantity(idQuantity = param)
    }
}