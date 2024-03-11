package com.BySandS.testsandquizes.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.BySandS.testsandquizes.data.entity.CategoryDbEntity
import com.BySandS.testsandquizes.data.entity.DifficultyDbEntity
import com.BySandS.testsandquizes.data.entity.QuantityOfQuestionsDbEntity
import com.BySandS.testsandquizes.data.entity.QuestionDbEntity
import com.BySandS.testsandquizes.data.entity.ResultDbEntity
import com.BySandS.testsandquizes.data.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.entity.SubcategoryDifficultyLevel
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoQuantityOfQuestion
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoQuestionRu
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoResult
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoSubcategory

@Database(
    entities = [
        CategoryDbEntity::class,
        DifficultyDbEntity::class,
        QuantityOfQuestionsDbEntity::class,
        QuestionDbEntity::class,
        ResultDbEntity::class,
        SubcategoryDbEntity::class,
        SubcategoryDifficultyLevel::class
    ], version = 7, exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 4, to = 7, spec = AutoMigrationSpecFrom4To7::class)
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun subcategoryDao(): DaoSubcategory
    abstract fun questionDao(): DaoQuestionRu
    abstract fun quantityOfQuestionDao(): DaoQuantityOfQuestion
    abstract fun resultDao(): DaoResult


    companion object {
        private const val DATABASE_NAME = "tests-database"

        /**
         * As we need only one instance of db in our app will use to store
         * This is to avoid memory leaks in android when there exist multiple instances of db
         */
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).createFromAsset("database/tests-database.db")
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }
}
