package com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryAndStatisticModelDb
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb

@Dao
interface DaoSubcategory {
    @Query(
        "SELECT subcategory.id, categories.category_name_ru, subcategory.subcategory_name_ru," +
                " statistic_subcategory.easy, statistic_subcategory.norm, statistic_subcategory.hard " +
                "FROM subcategory " +
                "JOIN statistic_subcategory ON subcategory.statistic_id = statistic_subcategory.id " +
                "JOIN categories ON subcategory.category_id = categories.id " +
                "WHERE subcategory.category_id = :idCategory"
    )
     fun getListSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryAndStatisticModelDb>
     @Query(
        "SELECT subcategory.id, categories.category_name_ru, subcategory.subcategory_name_ru," +
                " statistic_subcategory.easy, statistic_subcategory.norm, statistic_subcategory.hard " +
                "FROM subcategory " +
                "JOIN statistic_subcategory ON subcategory.statistic_id = statistic_subcategory.id " +
                "JOIN categories ON subcategory.category_id = categories.id " +
                "WHERE subcategory.id = :idSubcategory"
    )
     fun getSubcategoriesAndStatistics(idSubcategory: Long): SubcategoryAndStatisticModelDb

     @Query(
         "SELECT * FROM subcategory WHERE id = :idSubcategory"
     )
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb

}