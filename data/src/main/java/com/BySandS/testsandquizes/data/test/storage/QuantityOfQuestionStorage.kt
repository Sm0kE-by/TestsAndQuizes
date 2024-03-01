package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.QuantityOfQuestionModelDb

interface QuantityOfQuestionStorage {
    fun getQuantity(idQuantity: Long): QuantityOfQuestionModelDb
}