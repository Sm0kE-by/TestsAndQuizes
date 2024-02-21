package com.BySandS.testsandquizes.data.test.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.models.SubcategoryModelDb

@Dao
interface TestSubcategoryDaoRu {
    @Query(
        "SELECT subcategory.id, categories.category_name_ru, subcategory.subcategory_name_ru," +
                " statistic_subcategory.easy, statistic_subcategory.norm, statistic_subcategory.hard " +
                "FROM subcategory " +
                "JOIN statistic_subcategory ON subcategory.statistic_id = statistic_subcategory.id " +
                "JOIN categories ON subcategory.category_id = categories.id " +
                "WHERE subcategory.category_id = :idCategory"
    )
    fun getSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryModelDb>
}