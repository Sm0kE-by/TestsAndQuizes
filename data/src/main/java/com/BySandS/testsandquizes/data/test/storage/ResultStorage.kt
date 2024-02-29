package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.ResultTextModelDb
import com.BySandS.testsandquizes.domain.tests.models.GetResultParam

interface ResultStorage {
    fun getResult(testResultId: Long, difficultyId: Long): ResultTextModelDb
}