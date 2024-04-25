package com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface

import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.ResultModelDb

interface ResultStorage {
    fun getResult(subcategoryId: Long, difficultyId: Long): ResultModelDb
}