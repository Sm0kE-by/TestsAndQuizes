package com.BySandS.testsandquizes.data.storage.tests.dataBase

import android.content.Context
import android.util.Log
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.CategoryDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.DifficultyDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.QuantityOfQuestionsDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.QuestionDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.ResultDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.SubcategoryDifficultyLevel
import com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.interfaceDao.DaoQuantityOfQuestion
import com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.interfaceDao.DaoQuestionRu
import com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.interfaceDao.DaoResult
import com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.interfaceDao.DaoSubcategory

private const val TAG = "AAA"

@Database(
    entities = [
        CategoryDbEntity::class,
        DifficultyDbEntity::class,
        QuantityOfQuestionsDbEntity::class,
        QuestionDbEntity::class,
        ResultDbEntity::class,
        SubcategoryDbEntity::class,
        SubcategoryDifficultyLevel::class
    ], version = 3, exportSchema = true,
    autoMigrations = [
 AutoMigration(from = 2, to = 3),
//       // AutoMigration(from = 3, to = 4),
//        AutoMigration(from = 2, to = 7, spec = AutoMigrationSpecFrom4To7::class),
//      //   AutoMigration(from = 5, to = 6),
//      //   AutoMigration(from = 6, to = 7),
//        AutoMigration(from = 7, to = 10),
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun subcategoryDao(): DaoSubcategory
    abstract fun questionDao(): DaoQuestionRu
    abstract fun quantityOfQuestionDao(): DaoQuantityOfQuestion
    abstract fun resultDao(): DaoResult


    companion object {
        private const val DATABASE_NAME = "tests-database.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).createFromAsset("database/tests-database.db")
                    //.fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                Log.i(TAG, "ID_Category = $instance")
            }
            return instance
        }
    }
}
