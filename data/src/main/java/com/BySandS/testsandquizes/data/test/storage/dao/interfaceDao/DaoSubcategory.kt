package com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb

@Dao
interface DaoSubcategory {
    @Query(
        "SELECT * FROM subcategory WHERE subcategory.category_id = :idCategory"
    )
    fun getListSubcategories(idCategory: Long): List<SubcategoryModelDb>

    @Query(
        "SELECT * FROM subcategory WHERE id = :idSubcategory"
    )
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb

}