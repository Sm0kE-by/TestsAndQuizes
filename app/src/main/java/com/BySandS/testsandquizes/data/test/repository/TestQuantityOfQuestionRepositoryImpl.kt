package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import android.util.Log
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.repository.QuantityOfQuestionRepository

private const val TAG = "AAA"
class TestQuantityOfQuestionRepositoryImpl(context: Context): QuantityOfQuestionRepository {

    private val testsQuantityDaoRu = AppDatabase.getInstance(context).testsQuantityOfQuestion()

    override fun getQuantity(param: GetQuantityOfQuestionParam): QuantityOfQuestionModel {
        val quantity = testsQuantityDaoRu.getQuantityOfQuestion(idSubcategory = param.idSubcategory)
        Log.e(TAG, "$quantity")
        return QuantityOfQuestionModel(
            id = quantity.id,
            easyQuantity = quantity.easyQuantity,
            normQuantity = quantity.normQuantity,
            hardQuantity = quantity.hardQuantity
            )
    }
}