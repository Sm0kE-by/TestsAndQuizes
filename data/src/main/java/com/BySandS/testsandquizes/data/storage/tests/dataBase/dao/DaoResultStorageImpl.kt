package com.BySandS.testsandquizes.data.storage.tests.dataBase.dao

import android.content.Context
import com.BySandS.testsandquizes.data.storage.tests.dataBase.AppDatabase
import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.ResultStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.ResultModelDb

class DaoResultStorageImpl(context: Context): ResultStorage {

    private val testDao = AppDatabase.getInstance(context).resultDao()
    override fun getResult(subcategoryId: Long, difficultyId: Long): ResultModelDb {
       return testDao.getResult(subcategoryId = subcategoryId, difficultyId = difficultyId)
    }

}