package com.BySandS.testsandquizes.domain.tests.repository.tests

import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam


interface TestQuestionRepository {

    fun getQuestionsList(param: GetQuestionListParam): List<QuestionModel>

}