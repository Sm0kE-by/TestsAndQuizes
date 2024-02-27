package com.BySandS.testsandquizes.domain.tests.repository

interface QuantityOfQuestionRepository {

    fun getQuantity(idQuantity: com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam): com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel

}