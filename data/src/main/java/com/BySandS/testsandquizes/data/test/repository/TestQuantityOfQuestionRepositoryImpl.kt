package com.BySandS.testsandquizes.data.test.repository

import com.BySandS.testsandquizes.data.test.storage.QuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.test.storage.models.QuantityOfQuestionModelDb
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.repository.QuantityOfQuestionRepository

private const val TAG = "AAA"

class TestQuantityOfQuestionRepositoryImpl(private val quantityOfQuestionStorage: QuantityOfQuestionStorage) :
    QuantityOfQuestionRepository {

    override fun getQuantity(param: GetQuantityOfQuestionParam): QuantityOfQuestionModel {
        return mapToDomain(
            quantityOfQuestionModelDb = quantityOfQuestionStorage.getQuantity(
                idQuantity = mapToStorage(param = param)
            )
        )
    }

    private fun mapToDomain(quantityOfQuestionModelDb: QuantityOfQuestionModelDb): QuantityOfQuestionModel {
        return QuantityOfQuestionModel(
            id = quantityOfQuestionModelDb.id,
            easyQuantity = quantityOfQuestionModelDb.easyQuantity,
            normQuantity = quantityOfQuestionModelDb.normQuantity,
            hardQuantity = quantityOfQuestionModelDb.hardQuantity
        )
    }

    private fun mapToStorage(param: GetQuantityOfQuestionParam): Long {
        return param.idQuantity
    }

}