package com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.SubcategoryModelForSubcategoryFragmentDb

@Dao
interface DaoSubcategory {
    @Query(
        "SELECT id, name_ru as name, statistic_easy, statistic_norm, statistic_hard, statistic_veryhard, link_to_icon " +
                "FROM subcategory WHERE subcategory.category_id = :idCategory"
    )
    fun getListSubcategories(idCategory: Long): List<SubcategoryModelForSubcategoryFragmentDb>

    @Query(
        "SELECT * FROM subcategory WHERE id = :idSubcategory"
    )
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb

    @Update
    fun updateSubcategory(subcategory: SubcategoryDbEntity)
}