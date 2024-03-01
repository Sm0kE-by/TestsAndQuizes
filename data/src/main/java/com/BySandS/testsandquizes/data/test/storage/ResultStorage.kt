package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.ResultTextModelDb

interface ResultStorage {
    fun getResult(testResultId: Long, difficultyId: Long): ResultTextModelDb
}