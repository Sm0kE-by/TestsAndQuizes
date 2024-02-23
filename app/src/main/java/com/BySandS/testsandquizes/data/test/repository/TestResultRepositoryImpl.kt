package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import android.util.Log
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.domain.tests.models.GetResultParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository

private const val TAG = "AAA"

class TestResultRepositoryImpl(context: Context) : TestResultRepository {

    private val testsResultDaoRu = AppDatabase.getInstance(context).testsResult()

    override fun getResult(param: GetResultParam): ResultTestModel {
        val result = testsResultDaoRu.getResult(
            testResultId = param.testResultId,
            difficultyId = param.difficultyId
        )
        Log.e(TAG, "$result")
        return ResultTestModel(
            id = result.id,
            resultText33Ru = result.resultText33,
            resultText66Ru = result.resultText66,
            resultText99Ru = result.resultText99,
            resultText100Ru = result.resultText100
        )
    }
}