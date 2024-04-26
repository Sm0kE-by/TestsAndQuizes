package com.BySandS.testsandquizes.data.tests.storage.storageInterface

import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.ResultModelDb

interface ResultStorage {
    fun getResult(subcategoryId: Long, difficultyId: Long): ResultModelDb
}