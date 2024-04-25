package com.BySandS.testsandquizes.data.storage.tests.dataBase.dao

import android.content.Context
import com.BySandS.testsandquizes.data.storage.tests.dataBase.AppDatabase
import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.QuestionStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.QuestionModelDb

class DaoQuestionStorageImpl(context: Context) : QuestionStorage {

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