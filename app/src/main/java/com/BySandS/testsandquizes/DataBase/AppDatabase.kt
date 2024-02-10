package com.BySandS.testsandquizes.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.BySandS.testsandquizes.DataBase.entity.CategoryDbEntity
import com.BySandS.testsandquizes.DataBase.entity.DifficultyDbEntity
import com.BySandS.testsandquizes.DataBase.entity.QuantityOfQuestionsDbEntity
import com.BySandS.testsandquizes.DataBase.entity.QuestionDbEntity
import com.BySandS.testsandquizes.DataBase.entity.QuestionTextDbEntity
import com.BySandS.testsandquizes.DataBase.entity.ResultDbEntity
import com.BySandS.testsandquizes.DataBase.entity.ResultTextDbEntity
import com.BySandS.testsandquizes.DataBase.entity.ResultsTestDbEntity
import com.BySandS.testsandquizes.DataBase.entity.StatisticsDbEntity
import com.BySandS.testsandquizes.DataBase.entity.SubcategoryDbEntity

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
    ], version = 3, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun testsDaoRu(): TestsDaoRu

}