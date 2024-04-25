package com.BySandS.testsandquizes.domain.tests.repository.tests

import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam

interface TestQuantityOfQuestionRepository {

    fun getQuantity(param: GetQuantityOfQuestionParam): QuantityOfQuestionModel

}