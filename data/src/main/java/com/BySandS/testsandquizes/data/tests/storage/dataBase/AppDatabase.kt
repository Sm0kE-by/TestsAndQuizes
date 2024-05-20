package com.BySandS.testsandquizes.data.tests.storage.dataBase

import android.content.Context
import android.util.Log
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.BySandS.testsandquizes.data.allData.storage.dataBase.entity.AvatarDbEntity
import com.BySandS.testsandquizes.data.allData.storage.dataBase.entity.AvatarTypeDbEntity
import com.BySandS.testsandquizes.data.allData.storage.dataBase.intefaceDao.DaoAvatar
import com.BySandS.testsandquizes.data.tests.storage.dataBase.dao.interfaceDao.DaoQuantityOfQuestion
import com.BySandS.testsandquizes.data.tests.storage.dataBase.dao.interfaceDao.DaoQuestionRu
import com.BySandS.testsandquizes.data.tests.storage.dataBase.dao.interfaceDao.DaoResult
import com.BySandS.testsandquizes.data.tests.storage.dataBase.dao.interfaceDao.DaoSubcategory
import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.CategoryDbEntity
import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.DifficultyDbEntity
import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.QuantityOfQuestionsDbEntity
import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.QuestionDbEntity
import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.ResultDbEntity
import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.SubcategoryDifficultyLevel

private const val TAG = "AAA"

@Database(
    entities = [
        CategoryDbEntity::class,
        DifficultyDbEntity::class,
        QuantityOfQuestionsDbEntity::class,
        QuestionDbEntity::class,
        ResultDbEntity::class,
        SubcategoryDbEntity::class,
        SubcategoryDifficultyLevel::class,
        AvatarDbEntity::class,
        AvatarTypeDbEntity::class,
    ], version = 4, exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 3, to = 4),
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
    abstract fun avatarDao(): DaoAvatar


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
