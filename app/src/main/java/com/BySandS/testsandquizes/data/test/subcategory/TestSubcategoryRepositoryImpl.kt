package com.BySandS.testsandquizes.data.test.subcategory

import android.content.Context
import androidx.room.Room
import com.BySandS.testsandquizes.data.AppDatabase

private const val DATABASE_NAME = "tests-database"
class TestSubcategoryRepositoryImpl private constructor(context: Context) {

    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    )
        .createFromAsset("database/tests-database.db")
        .build()

    private val testsDaoRu = database.testsSubcategoryDaoRu()

    fun getAllSubcategories() = testsDaoRu.getSubcategoriesAndStatistics()

    companion object {
        private var INSTANCE: TestSubcategoryRepositoryImpl? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TestSubcategoryRepositoryImpl(context)
            }
        }

        fun get(): TestSubcategoryRepositoryImpl {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}