package com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface

import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.QuantityOfQuestionModelDb

interface QuantityOfQuestionStorage {
    fun getQuantity(idQuantity: Long): QuantityOfQuestionModelDb
}