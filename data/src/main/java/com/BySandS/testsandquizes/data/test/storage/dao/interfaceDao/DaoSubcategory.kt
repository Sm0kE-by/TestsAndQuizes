package com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelForSubcategoryFragmentDb

@Dao
interface DaoSubcategory {
    @Query(
        "SELECT id, name_ru as name, statistic_easy, statistic_norm, statistic_hard, link_to_icon " +
                "FROM subcategory WHERE subcategory.category_id = :idCategory"
    )
    fun getListSubcategories(idCategory: Long): List<SubcategoryModelForSubcategoryFragmentDb>

    @Query(
        "SELECT * FROM subcategory WHERE id = :idSubcategory"
    )
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb

}