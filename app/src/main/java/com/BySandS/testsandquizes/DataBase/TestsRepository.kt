package com.BySandS.testsandquizes.DataBase

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.BySandS.testsandquizes.DataBase.entity.QuantityOfQuestionsDbEntity
import com.BySandS.testsandquizes.DataBase.entity.StatisticsDbEntity
import com.BySandS.testsandquizes.DataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.DataBase.models.SubcategoryModel

private const val DATABASE_NAME = "crime-database"
class TestsRepository private constructor(context: Context) {

    private val database : AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val testsDaoRu = database.testsDaoRu()

    /**
     * Functions
     */
    fun getAllSubcategories(): LiveData<List<SubcategoryModel>> = testsDaoRu.getAllSubcategories()
    fun getSubcategoryById(id: Long): LiveData<SubcategoryDbEntity?> = testsDaoRu.getSubcategoryById(id)
    fun getStatisticById(id: Long): LiveData<StatisticsDbEntity?> = testsDaoRu.getStatisticById(id)
    fun getQuantityOfQuestionsById(id: Long): LiveData<QuantityOfQuestionsDbEntity?> = testsDaoRu.getQuantityOfQuestionsById(id)

    companion object {
        private var INSTANCE: TestsRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TestsRepository(context)
            }
        }
        fun get(): TestsRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }

}