package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam

interface TestQuantityOfQuestionRepository {

    fun getQuantity(idQuantity: GetQuantityOfQuestionParam): QuantityOfQuestionModel

}