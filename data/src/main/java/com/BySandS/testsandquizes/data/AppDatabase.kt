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
import com.BySandS.testsandquizes.data.entity.QuestionTextDbEntity
import com.BySandS.testsandquizes.data.entity.ResultDbEntity
import com.BySandS.testsandquizes.data.entity.ResultTextDbEntity
import com.BySandS.testsandquizes.data.entity.ResultsTestDbEntity
import com.BySandS.testsandquizes.data.entity.StatisticsDbEntity
import com.BySandS.testsandquizes.data.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoQuantityOfQuestion
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoQuestionRu
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoResult
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoStatistic
import com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao.DaoSubcategory

@Database(
    entities = [
        CategoryDbEntity::class,
        DifficultyDbEntity::class,
        QuantityOfQuestionsDbEntity::class,
        QuestionDbEntity::class,
        QuestionTextDbEntity::class,
        ResultDbEntity::class,
        ResultsTestDbEntity::class,
        ResultTextDbEntity::class,
        StatisticsDbEntity::class,
        SubcategoryDbEntity::class
    ], version = 4, exportSchema = true,
    autoMigrations = [AutoMigration(from = 3, to = 4)]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun subcategoryDao(): DaoSubcategory
    abstract fun questionDao(): DaoQuestionRu
    abstract fun quantityOfQuestionDao(): DaoQuantityOfQuestion
    abstract fun resultDao(): DaoResult
    abstract fun statisticDao(): DaoStatistic

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
