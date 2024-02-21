package com.BySandS.testsandquizes.data.test.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.BySandS.testsandquizes.data.test.models.QuestionModelDb
import com.BySandS.testsandquizes.data.test.models.StatisticModelDb
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel

@Dao
interface TestQuestionDaoRu {
    @Query("SELECT question_text.id, question_text_ru, correct_answer_ru," +
            "incorrect_answer_1_ru, incorrect_answer_2_ru," +
            "incorrect_answer_3_ru " +
            "FROM question_text, question " +
           // "JOIN question_text ON question.question_text_id = question_text.id " +
            "WHERE question.difficulty_id = :difficultyId AND question_text.id = question.question_text_id " +
            "ORDER BY RANDOM() LIMIT :quantityOfQuestions")
    fun getQuestionsListByDifficulty(difficultyId: Int, quantityOfQuestions: Int): QuestionModelDb
}