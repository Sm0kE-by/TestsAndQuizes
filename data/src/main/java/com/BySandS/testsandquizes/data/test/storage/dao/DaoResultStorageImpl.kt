package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.ResultStorage
import com.BySandS.testsandquizes.data.test.storage.models.ResultTextModelDb

class DaoResultStorageImpl(context: Context): ResultStorage {

    private val testDao = AppDatabase.getInstance(context).resultDao()
    override fun getResult(testResultId: Long, difficultyId: Long): ResultTextModelDb {
       return testDao.getResult(testResultId = testResultId, difficultyId = difficultyId)
    }

}