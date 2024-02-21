package com.BySandS.testsandquizes.data.test.dao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.models.ResultModelDb

@Dao
interface TestResultDao {

    @Query("SELECT result_text.id as result_text_id, result_text_33_ru as result_text_33, " +
            "result_text_66_ru as result_text_66, result_text_99_ru as result_text_99, " +
            "result_text_100_ru as result_text_100 " +
            "FROM result_text, result " +
            "WHERE result.result_text_id = result_text.id " +
            "AND result.difficulty_id = :difficultyId " +
            "AND result.test_result_id = :testResultId")
    fun getResult(testResultId: Int, difficultyId: Int): ResultModelDb

}