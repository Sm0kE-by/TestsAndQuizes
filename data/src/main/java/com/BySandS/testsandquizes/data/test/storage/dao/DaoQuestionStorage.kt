package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.QuestionStorage
import com.BySandS.testsandquizes.data.test.storage.models.QuestionModelDb

class DaoQuestionStorage(context: Context) : QuestionStorage {

    private val testDao = AppDatabase.getInstance(context).questionDao()
    override fun getQuestionsList(
        difficultyId: Long,
        quantityOfQuestions: Int
    ): List<QuestionModelDb> {
        return testDao.getQuestionsListByDifficulty(
            difficultyId = difficultyId,
            quantityOfQuestions = quantityOfQuestions
        )
    }


}