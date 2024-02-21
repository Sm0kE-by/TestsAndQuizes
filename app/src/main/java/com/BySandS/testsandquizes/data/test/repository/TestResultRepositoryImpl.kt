package com.BySandS.testsandquizes.data.test.repository

import com.BySandS.testsandquizes.domain.tests.models.GetResultParam
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository

class TestResultRepositoryImpl:TestResultRepository {
    override fun getResult(param: GetResultParam): ResultTestModel {
        TODO("Not yet implemented")
    }
}