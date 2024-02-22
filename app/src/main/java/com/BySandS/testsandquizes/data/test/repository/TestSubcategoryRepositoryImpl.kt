package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import android.util.Log
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository
private const val TAG = "AAA"
//private const val DATABASE_NAME = "tests-database"
class TestSubcategoryRepositoryImpl(context: Context) : TestSubcategoryRepository {
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
        Log.e(TAG, "$list1\n")
        var listSubcategoryModel = ArrayList<SubcategoryModel>()
        Log.e(TAG, "$listSubcategoryModel")
        list1.forEach{ it->
            listSubcategoryModel.add(SubcategoryModel(
                id = it.id,
                typeName = it.typeName,
                subcategoryName = it.subcategoryName,
                statisticEasyPercent = it.statisticEasy,
                statisticNormPercent = it.statisticNorm,
                statisticHardPercent = it.statisticHard))
        }
        Log.e(TAG, "$listSubcategoryModel")
        val list2:List<SubcategoryModel> = listSubcategoryModel
        Log.e(TAG, "$list2")
        return listSubcategoryModel
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