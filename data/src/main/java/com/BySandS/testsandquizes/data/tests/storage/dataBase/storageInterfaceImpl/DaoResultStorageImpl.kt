package com.BySandS.testsandquizes.data.tests.storage.dataBase.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.tests.storage.dataBase.AppDatabase
import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.ResultModelDb
import com.BySandS.testsandquizes.data.tests.storage.storageInterface.ResultStorage

class DaoResultStorageImpl(context: Context): ResultStorage {

    private val testDao = AppDatabase.getInstance(context).resultDao()
    override fun getResult(subcategoryId: Long, difficultyId: Long): ResultModelDb {
       return testDao.getResult(subcategoryId = subcategoryId, difficultyId = difficultyId)
    }

}