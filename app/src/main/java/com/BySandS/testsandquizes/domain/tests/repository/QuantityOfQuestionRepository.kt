package com.BySandS.testsandquizes.domain.tests.repository

import android.content.Context
import com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel

interface QuantityOfQuestionRepository {

    fun getQuantity(idSubcategory: GetQuantityOfQuestionParam): QuantityOfQuestionModel

}