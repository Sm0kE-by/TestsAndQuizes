package com.BySandS.testsandquizes.data.tests.storage.storageInterface

import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.QuestionModelDb

interface QuestionStorage {
    fun getQuestionsList(difficultyId: Long, quantityOfQuestions: Int): List<QuestionModelDb>
}