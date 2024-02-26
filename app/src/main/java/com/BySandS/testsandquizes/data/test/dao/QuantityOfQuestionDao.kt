package com.BySandS.testsandquizes.data.test.dao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.models.QuantityOfQuestionModelDb

@Dao
interface QuantityOfQuestionDao {

    @Query("SELECT * FROM quantity_of_questions, subcategory " +
            "WHERE subcategory.quantity_of_questions_id = :idQuantity"
    )
    fun getQuantityOfQuestion(idQuantity: Long): QuantityOfQuestionModelDb
}