package com.BySandS.testsandquizes.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.DataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.DataBase.models.SubcategoryModelDB

@Dao
interface TestsDaoRu {
//
    @Query("SELECT * FROM subcategory")
    fun getAllSubcategories(): LiveData<List<SubcategoryDbEntity>>

@Query("SELECT subcategory.id, categories.category_name_ru, subcategory.subcategory_name_ru," +
           " statistic_subcategory.easy, statistic_subcategory.norm, statistic_subcategory.hard " +
          "FROM subcategory " +
           "JOIN statistic_subcategory ON subcategory.statistic_id = statistic_subcategory.id "+
           "JOIN categories ON subcategory.category_id = categories.id ")
fun getSubcategoriesAndStatistics(): LiveData<List<SubcategoryModelDB>>

//    @Query("SELECT * FROM subcategory WHERE id=(:id)")
//    fun getSubcategoryById(id: Long): LiveData<SubcategoryDbEntity?>
//
////    @Query("SELECT subcategory.id, subcategory_name_ru, statistic_id, " +
////            "category_id, quantity_of_questions_id, test_result_id FROM subcategory")
////    fun getAllSubcategories(): LiveData<List<SubcategoryModel>>

////    @Query("SELECT * FROM subcategory WHERE id=(:id)")
////    fun getSubcategoryById(id: Long):  LiveData<SubcategoryDbEntity?>
//
//    @Query("SELECT * FROM statistic_subcategory WHERE id=(:id)")
//    fun getStatisticById(id: Long):  LiveData<StatisticsDbEntity?>
//    @Query("SELECT * FROM quantity_of_questions WHERE id=(:id)")
//    fun getQuantityOfQuestionsById(id: Long):  LiveData<QuantityOfQuestionsDbEntity?>



}