package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel

interface TestQuestionRepository {

    fun getQuestionsList(getQuestionListParam: GetQuestionListParam): List<QuestionModel>

}