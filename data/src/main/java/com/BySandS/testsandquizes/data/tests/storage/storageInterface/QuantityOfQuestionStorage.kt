package com.BySandS.testsandquizes.data.tests.storage.storageInterface

import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.QuantityOfQuestionModelDb

interface QuantityOfQuestionStorage {
    fun getQuantity(idQuantity: Long): QuantityOfQuestionModelDb
}