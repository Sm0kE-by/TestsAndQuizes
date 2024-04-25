package com.BySandS.testsandquizes.domain.tests.repository.tests

import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetResultParam

interface TestResultRepository {

    fun getResult(param: GetResultParam): ResultTestModel

}