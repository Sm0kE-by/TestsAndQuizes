package com.BySandS.testsandquizes.domain.tests.usecase.testActivity

import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.repository.TestQuestionRepository

class GetQuestionListUseCase(private val tesQuestionRepository: TestQuestionRepository) {

    fun execute(param: GetQuestionListParam): List<QuestionModel>{
        return tesQuestionRepository.getQuestionsList(param = param)
    }
}