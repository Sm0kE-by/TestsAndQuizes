package com.BySandS.testsandquizes.data

import androidx.room.AutoMigration
import androidx.room.Database
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
import com.BySandS.testsandquizes.data.test.question.TestQuestionDaoRu
import com.BySandS.testsandquizes.data.test.subcategory.TestSubcategoryDaoRu

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
    ], version = 3, exportSchema = true,
    autoMigrations = [AutoMigration(from = 2, to = 3)]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun testsSubcategoryDaoRu(): TestSubcategoryDaoRu
    abstract fun testsQuestionDaoRu(): TestQuestionDaoRu
}