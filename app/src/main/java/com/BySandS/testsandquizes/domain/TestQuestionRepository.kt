package com.BySandS.testsandquizes.domain

import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel

interface TestQuestionRepository {

    fun getQuestionsListByDifficulty(difficultyId: Int, quantityOfQuestions: Int): QuestionModel
    fun getStatistic(idSubcategory: Int): StatisticModel
    fun saveStatistic(statisticModel: StatisticModel): Boolean
    fun getResult(testResultId: Int, difficultyId: Int): ResultTestModel
}