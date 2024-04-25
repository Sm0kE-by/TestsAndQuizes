package com.BySandS.testsandquizes.data.tests.repositry

import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.QuestionStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.QuestionModelDb
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.repository.tests.TestQuestionRepository

class TestQuestionRepositoryImpl(private val questionStorage: QuestionStorage) :
    TestQuestionRepository {

    override fun getQuestionsList(param: GetQuestionListParam): List<QuestionModel> {
        return mapToDomain(
            questionStorage.getQuestionsList(
                difficultyId = mapToStorageDifficulty(param = param),
                quantityOfQuestions = mapToStorageQuantity(param = param)
            )
        )
    }

    private fun mapToDomain(listQuestionModel: List<QuestionModelDb>): List<QuestionModel> {
        var listQuestionsModel = ArrayList<QuestionModel>()
        listQuestionModel.forEach { it ->
            listQuestionsModel.add(
                QuestionModel(
                    id = it.id,
                    questionText = it.textRu,
                    correctAnswer = it.correctAnswerRu,
                    incorrectAnswer1 = it.incorrectAnswer1Ru,
                    incorrectAnswer2 = it.incorrectAnswer2Ru,
                    incorrectAnswer3 = it.incorrectAnswer3Ru
                )
            )
        }
        return listQuestionsModel
    }

    private fun mapToStorageDifficulty(param: GetQuestionListParam): Long {
        return param.difficultyId
    }

    private fun mapToStorageQuantity(param: GetQuestionListParam): Int {
        return param.quantityOfQuestions
    }
}