package com.BySandS.testsandquizes.data.tests.storage.dataBase.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.tests.storage.dataBase.AppDatabase
import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.QuestionModelDb
import com.BySandS.testsandquizes.data.tests.storage.storageInterface.QuestionStorage

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