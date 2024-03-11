package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.ResultModelDb

interface ResultStorage {
    fun getResult(subcategoryId: Long, difficultyId: Long): ResultModelDb
}