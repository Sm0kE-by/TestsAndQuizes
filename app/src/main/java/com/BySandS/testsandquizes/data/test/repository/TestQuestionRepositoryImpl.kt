package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import androidx.room.Room
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.domain.tests.models.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.repository.TestQuestionRepository
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
    override fun getQuestionsList(getQuestionListParam: GetQuestionListParam): List<QuestionModel> {
        TODO("Not yet implemented")
    }

}