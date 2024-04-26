package com.BySandS.testsandquizes.data.tests.storage.dataBase.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.tests.storage.dataBase.AppDatabase
import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.QuantityOfQuestionModelDb
import com.BySandS.testsandquizes.data.tests.storage.storageInterface.QuantityOfQuestionStorage

class DaoQuantityOfQuestionStorageImpl(context: Context): QuantityOfQuestionStorage {

    private val testDao = AppDatabase.getInstance(context).quantityOfQuestionDao()
    override fun getQuantity(idQuantity: Long): QuantityOfQuestionModelDb {
       return testDao.getQuantityOfQuestion(idQuantity = idQuantity)
    }
}