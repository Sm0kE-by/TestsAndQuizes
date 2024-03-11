package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.QuestionModelDb

interface QuestionStorage {
    fun getQuestionsList(difficultyId: Long, quantityOfQuestions: Long): List<QuestionModelDb>
}