package com.BySandS.testsandquizes.data.storage.tests.dataBase.dao

import android.content.Context
import com.BySandS.testsandquizes.data.storage.tests.dataBase.AppDatabase
import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.QuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.QuantityOfQuestionModelDb

class DaoQuantityOfQuestionStorageImpl(context: Context): QuantityOfQuestionStorage {

    private val testDao = AppDatabase.getInstance(context).quantityOfQuestionDao()
    override fun getQuantity(idQuantity: Long): QuantityOfQuestionModelDb {
       return testDao.getQuantityOfQuestion(idQuantity = idQuantity)
    }
}