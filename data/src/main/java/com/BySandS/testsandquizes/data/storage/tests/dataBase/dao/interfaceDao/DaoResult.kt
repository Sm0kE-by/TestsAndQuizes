package com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.ResultModelDb

@Dao
interface DaoResult {

    @Query("SELECT result.id, result.result_text_33_ru, result.result_text_66_ru, " +
            "result.result_text_99_ru, result.result_text_100_ru FROM  result, subcategory " +
            "WHERE  result.difficulty_level_id = :difficultyId " +
            "AND subcategory.id = :subcategoryId")
    fun getResult(subcategoryId: Long, difficultyId: Long): ResultModelDb

}