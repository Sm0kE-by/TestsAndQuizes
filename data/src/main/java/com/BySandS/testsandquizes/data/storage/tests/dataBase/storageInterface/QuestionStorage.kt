package com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface

import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.QuestionModelDb

interface QuestionStorage {
    fun getQuestionsList(difficultyId: Long, quantityOfQuestions: Int): List<QuestionModelDb>
}