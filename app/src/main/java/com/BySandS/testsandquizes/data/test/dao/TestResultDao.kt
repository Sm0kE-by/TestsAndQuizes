package com.BySandS.testsandquizes.data.test.dao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.models.ResultModelDb

@Dao
interface TestResultDao {

    @Query("SELECT result_text.id, result_text.result_text_33_ru , " +
            "result_text.result_text_66_ru , result_text.result_text_99_ru , " +
            "result_text.result_text_100_ru  " +
            "FROM result_text, result " +
            "WHERE result.result_text_id = result_text.id " +
            "AND result.difficulty_id = :difficultyId " +
            "AND result.test_result_id = :testResultId")
    fun getResult(testResultId: Long, difficultyId: Long): ResultModelDb

}