package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.GetResultParam
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel

interface TestResultRepository {

    fun getResult(param: com.BySandS.testsandquizes.domain.tests.models.GetResultParam): com.BySandS.testsandquizes.domain.tests.models.ResultTestModel

}