package com.BySandS.testsandquizes.DataBase

import android.content.Context
import androidx.room.Room

private const val DATABASE_NAME = "tests-database"

class TestsRepository private constructor(context: Context) {

    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    )
        .createFromAsset("tests-database.db")
        .build()

    private val testsDaoRu = database.testsDaoRu()

    fun getAllSubcategories() = testsDaoRu.getSubcategoriesAndStatistics()

//    fun getSubcategoryById(id: Long): LiveData<SubcategoryDbEntity?> = testsDaoRu.getSubcategoryById(id)
//    fun getStatisticById(id: Long): LiveData<StatisticsDbEntity?> = testsDaoRu.getStatisticById(id)
//    fun getQuantityOfQuestionsById(id: Long): LiveData<QuantityOfQuestionsDbEntity?> = testsDaoRu.getQuantityOfQuestionsById(id)

    companion object {
        private var INSTANCE: TestsRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TestsRepository(context)
            }
        }

        fun get(): TestsRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }

}