package com.BySandS.testsandquizes.domain.tests.repository


interface TestQuestionRepository {

    fun getQuestionsList(getQuestionListParam: com.BySandS.testsandquizes.domain.tests.models.GetQuestionListParam): List<com.BySandS.testsandquizes.domain.tests.models.QuestionModel>

}