package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam


interface TestQuestionRepository {

    fun getQuestionsList(getQuestionListParam: GetQuestionListParam): List<com.BySandS.testsandquizes.domain.tests.models.QuestionModel>

}