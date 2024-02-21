package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import androidx.room.Room
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.models.SubcategoryModelDb
import com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

//private const val DATABASE_NAME = "tests-database"
class TestSubcategoryRepositoryImpl private constructor(context: Context): TestSubcategoryRepository {
//
//    private val database: AppDatabase = Room.databaseBuilder(
//        context.applicationContext,
//        AppDatabase::class.java,
//        DATABASE_NAME
//    )
//        .createFromAsset("database/tests-database.db")
//        .build()

    //private val testsDaoRu = database.testsSubcategoryDaoRu()
    private val testsDaoRu = AppDatabase.getInstance(context).testsSubcategoryDaoRu()

   // fun getAllSubcategories() = testsDaoRu.getSubcategoriesAndStatistics()
    override fun getAllSubcategories(idCategory: GetCategoryParam): List<SubcategoryModel> {
        val list1 = testsDaoRu.getSubcategoriesAndStatistics(idCategory = idCategory.idCategory)


        var list :List<SubcategoryModel> = list1 as List<SubcategoryModel>
        return list
    }

//    companion object {
//        private var INSTANCE: TestSubcategoryRepositoryImpl? = null
//        fun initialize(context: Context) {
//            if (INSTANCE == null) {
//                INSTANCE = TestSubcategoryRepositoryImpl(context)
//            }
//        }
//
//        fun get(): TestSubcategoryRepositoryImpl {
//            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
//        }
//    }


}