package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam

interface QuantityOfQuestionRepository {

    fun getQuantity(idQuantity: GetQuantityOfQuestionParam): QuantityOfQuestionModel

}