package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import android.util.Log
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.ResultStorage
import com.BySandS.testsandquizes.data.test.storage.models.QuantityOfQuestionModelDb
import com.BySandS.testsandquizes.data.test.storage.models.ResultTextModelDb
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetResultParam
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository

private const val TAG = "AAA"

class TestResultRepositoryImpl(private val resultStorage: ResultStorage) : TestResultRepository {

    override fun getResult(param: GetResultParam): ResultTestModel {
        return mapToDomain(
            resultTextModelDb = resultStorage.getResult(
                testResultId = mapToStorageResultId(param = param),
                difficultyId = mapToStorageDifficultyId(param = param)
            )
        )
    }

    private fun mapToDomain(resultTextModelDb: ResultTextModelDb): ResultTestModel {
        return ResultTestModel(
            id = resultTextModelDb.id,
            resultText33Ru = resultTextModelDb.resultText33,
            resultText66Ru = resultTextModelDb.resultText66,
            resultText99Ru = resultTextModelDb.resultText99,
            resultText100Ru = resultTextModelDb.resultText100
        )
    }

    private fun mapToStorageResultId(param: GetResultParam): Long {
        return param.testResultId
    }

    private fun mapToStorageDifficultyId(param: GetResultParam): Long {
        return param.difficultyId
    }
}