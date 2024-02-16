package com.BySandS.testsandquizes.data.test.question

import android.content.Context
import androidx.room.Room
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.domain.TestQuestionRepository
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel

private const val DATABASE_NAME = "tests-database"
class TestQuestionRepositoryImpl private constructor(context: Context): TestQuestionRepository {

    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    )
        .createFromAsset("database/tests-database.db")
        .build()

    private val testsDaoRu = database.testsQuestionDaoRu()
    override fun getQuestionsListByDifficulty(
        difficultyId: Int,
        quantityOfQuestions: Int
    ): QuestionModel {
        TODO("Not yet implemented")
    }

    override fun getStatistic(idSubcategory: Int): StatisticModel {
        TODO("Not yet implemented")
    }

    override fun saveStatistic(statisticModel: StatisticModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun getResult(testResultId: Int, difficultyId: Int): ResultTestModel {
        TODO("Not yet implemented")
    }
}