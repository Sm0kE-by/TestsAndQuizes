package com.BySandS.testsandquizes.domain.tests.usecase.testActivity

import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.repository.TestQuestionRepository

class GetQuestionListUseCase(private val tesQuestionRepository: TestQuestionRepository) {


    fun execute(param: GetQuestionListParam): List<QuestionModel> {
        return checkDifficulty(param = param)
    }

    private fun checkDifficulty(param: GetQuestionListParam): List<QuestionModel> {

        val listQuestion = mutableListOf<QuestionModel>()
        when (param.difficultyId) {
            1L -> {
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId,
                            quantityOfQuestions = param.quantityOfQuestions - 1
                        )
                    )
                )
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId + 1L,
                            quantityOfQuestions = param.quantityOfQuestions - (param.quantityOfQuestions - 1)
                        )
                    )
                )
            }

            2L -> {
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId - 1L,
                            quantityOfQuestions = param.quantityOfQuestions - (param.quantityOfQuestions - 1)
                        )
                    )
                )
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId,
                            quantityOfQuestions = param.quantityOfQuestions - (param.quantityOfQuestions - 3)
                        )
                    )
                )
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId + 1L,
                            quantityOfQuestions = param.quantityOfQuestions - (param.quantityOfQuestions - 2)
                        )
                    )
                )
            }

            3L -> {
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId - 1L,
                            quantityOfQuestions = param.quantityOfQuestions - (param.quantityOfQuestions - 2)
                        )
                    )
                )
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId,
                            quantityOfQuestions = param.quantityOfQuestions - (param.quantityOfQuestions - 5)
                        )
                    )
                )
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId + 1L,
                            quantityOfQuestions = param.quantityOfQuestions - (param.quantityOfQuestions - 3)
                        )
                    )
                )
            }

            4L -> {
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId,
                            quantityOfQuestions = param.quantityOfQuestions - 3
                        )
                    )
                )
                listQuestion.addAll(
                    tesQuestionRepository.getQuestionsList(
                        param = GetQuestionListParam(
                            difficultyId = param.difficultyId - 1L,
                            quantityOfQuestions = param.quantityOfQuestions - (param.quantityOfQuestions - 3)
                        )
                    )
                )
            }
        }
        return listQuestion
    }
}