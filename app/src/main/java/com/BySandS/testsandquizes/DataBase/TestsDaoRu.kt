package com.BySandS.testsandquizes.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.DataBase.entity.QuantityOfQuestionsDbEntity
import com.BySandS.testsandquizes.DataBase.entity.StatisticsDbEntity
import com.BySandS.testsandquizes.DataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.DataBase.models.SubcategoryModel

@Dao
interface TestsDaoRu {

//    @Query("SELECT * FROM subcategory")
//    fun getAllCategories(): List<SubcategoryDbEntity>
//    @Query("SELECT * FROM subcategory WHERE id=(:id)")
//    fun getCategoryById(id: Long): SubcategoryDbEntity?
    @Query("SELECT subcategory.id, subcategory_name_ru, statistic_id, " +
            "category_id, quantity_of_questions_id, test_result_id FROM subcategory")
    fun getAllSubcategories(): LiveData<List<SubcategoryModel>>
    @Query("SELECT * FROM subcategory WHERE id=(:id)")
    fun getSubcategoryById(id: Long):  LiveData<SubcategoryDbEntity?>

    @Query("SELECT * FROM statistic_subcategory WHERE id=(:id)")
    fun getStatisticById(id: Long):  LiveData<StatisticsDbEntity?>
    @Query("SELECT * FROM quantity_of_questions WHERE id=(:id)")
    fun getQuantityOfQuestionsById(id: Long):  LiveData<QuantityOfQuestionsDbEntity?>



}