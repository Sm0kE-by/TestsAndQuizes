package com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.storage.models.QuantityOfQuestionModelDb

@Dao
interface DaoQuantityOfQuestion {

    @Query("SELECT * FROM quantity_of_questions, subcategory " +
            "WHERE subcategory.quantity_of_questions_id = :idQuantity"
    )
    fun getQuantityOfQuestion(idQuantity: Long): QuantityOfQuestionModelDb
}