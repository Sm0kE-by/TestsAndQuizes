package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.QuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.test.storage.models.QuantityOfQuestionModelDb

class DaoQuantityOfQuestionStorageImpl(context: Context): QuantityOfQuestionStorage {

    private val testDao = AppDatabase.getInstance(context).quantityOfQuestionDao()
    override fun getQuantity(idQuantity: Long): QuantityOfQuestionModelDb {
       return testDao.getQuantityOfQuestion(idQuantity = idQuantity)
    }
}