package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import android.util.Log
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.domain.tests.models.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.repository.TestQuestionRepository
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel

private const val TAG = "AAA"
class TestQuestionRepositoryImpl (context: Context): TestQuestionRepository {


    private val testsQuestionDaoRu = AppDatabase.getInstance(context).testsQuestionDaoRu()
    override fun getQuestionsList(param: GetQuestionListParam): List<QuestionModel> {
        val list1 = testsQuestionDaoRu.getQuestionsListByDifficulty(difficultyId = param.difficultyId,
            quantityOfQuestions = param.quantityOfQuestions)

        Log.e(TAG, "$list1\n")
        var listQuestionsModel = ArrayList<QuestionModel>()
        Log.e(TAG, "$listQuestionsModel")
        list1.forEach { it ->
            listQuestionsModel.add(
                QuestionModel(
                    id = it.id,
                    questionText = it.questionTextRu,
                    correctAnswer = it.correctAnswerRu,
                    incorrectAnswer1 = it.incorrectAnswer1Ru,
                    incorrectAnswer2 = it.incorrectAnswer2Ru,
                    incorrectAnswer3 = it.incorrectAnswer3Ru
                )
            )
        }
        Log.e(TAG, "$listQuestionsModel")
        return listQuestionsModel
    }
}