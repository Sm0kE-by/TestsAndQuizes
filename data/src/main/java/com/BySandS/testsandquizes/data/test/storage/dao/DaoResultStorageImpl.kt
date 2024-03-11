package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.ResultStorage
import com.BySandS.testsandquizes.data.test.storage.models.ResultModelDb

class DaoResultStorageImpl(context: Context): ResultStorage {

    private val testDao = AppDatabase.getInstance(context).resultDao()
    override fun getResult(subcategoryId: Long, difficultyId: Long): ResultModelDb {
       return testDao.getResult(subcategoryId = subcategoryId, difficultyId = difficultyId)
    }

}