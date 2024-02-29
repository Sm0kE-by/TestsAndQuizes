package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.QuestionModelDb
import com.BySandS.testsandquizes.domain.tests.models.GetQuestionListParam

interface QuestionStorage {
    fun getQuestionsList(difficultyId: Long, quantityOfQuestions: Int): List<QuestionModelDb>
}