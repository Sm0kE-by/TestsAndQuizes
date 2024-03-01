package com.BySandS.testsandquizes.presentation.testsActivity

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.data.test.repository.TestQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestResultRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestStatisticRepositoryImpl
import com.BySandS.testsandquizes.domain.tests.usecase.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestStatisticUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.SaveTestStatisticUseCase
import com.BySandS.testsandquizes.presentation.model.TestModelPresentation

private const val TAG = "AAA"

class TestFragmentViewModel(
    private val getTestResultUseCase: GetTestResultUseCase,
    private val getQuestionListUseCase: GetQuestionListUseCase,
    private val saveTestStatisticUseCase: SaveTestStatisticUseCase,
    private val getTestStatisticUseCase: GetTestStatisticUseCase
) : ViewModel() {

    //Пока вручную, потом буду принимать его на вход
    val testModelPresentation =
        TestModelPresentation(nameSubcategoryId = 1, difficultyId = 1, quantityOfQuestion = 7)

    val listQuestions: List<com.BySandS.testsandquizes.domain.tests.models.QuestionModel> = listOf(
        com.BySandS.testsandquizes.domain.tests.models.QuestionModel(
            1,
            "QuestionText 1",
            "Correct Answer 1",
            "Incorrect Answer 1 - 1",
            "Incorrect Answer 1 - 2",
            "Incorrect Answer 1 - 3"
        ),
        com.BySandS.testsandquizes.domain.tests.models.QuestionModel(
            2,
            "QuestionText 2",
            "Correct Answer 2",
            "Incorrect Answer 2 - 1",
            "Incorrect Answer 2 - 2",
            "Incorrect Answer 2 - 3"
        ),
        com.BySandS.testsandquizes.domain.tests.models.QuestionModel(
            3,
            "QuestionText 3",
            "Correct Answer 3",
            "Incorrect Answer 3 - 1",
            "Incorrect Answer 3 - 2",
            "Incorrect Answer 3 - 3"
        ),
        com.BySandS.testsandquizes.domain.tests.models.QuestionModel(
            4,
            "QuestionText 4",
            "Correct Answer 4",
            "Incorrect Answer 4 - 1",
            "Incorrect Answer 4 - 2",
            "Incorrect Answer 4 - 3"
        ),
        com.BySandS.testsandquizes.domain.tests.models.QuestionModel(
            5,
            "QuestionText 5",
            "Correct Answer 5",
            "Incorrect Answer 5 - 1",
            "Incorrect Answer 5 - 2",
            "Incorrect Answer 5 - 3"
        ),
        com.BySandS.testsandquizes.domain.tests.models.QuestionModel(
            6,
            "QuestionText 6",
            "Correct Answer 6",
            "Incorrect Answer 6 - 1",
            "Incorrect Answer 6 - 2",
            "Incorrect Answer 6 - 3"
        ),
        com.BySandS.testsandquizes.domain.tests.models.QuestionModel(
            7,
            "QuestionText 7",
            "Correct Answer 7",
            "Incorrect Answer 7 - 1",
            "Incorrect Answer 7 - 2",
            "Incorrect Answer 7 - 3"
        ),
    )

    //Или подгружать новый, или принимать на вход выбранный, пока руками написал
    var statisticModel =
        com.BySandS.testsandquizes.domain.tests.models.StatisticModel(1, "Cosmos", 30, 60, 90)

    //количество подсказок пока руками, модельки еще нет
    var quantityOfHint = 2
    var quantityCorrectAnswer = 0
    var quantityIncorrectAnswer = 0
    var quantityOfQuestion = 0

    fun calculateTheResult() {
        Log.e(TAG, "quantityCorrectAnswer - $quantityCorrectAnswer")
        val result = (quantityCorrectAnswer / listQuestions.size) * 100
        Log.e(
            TAG,
            "result $result% ${quantityCorrectAnswer}/${quantityCorrectAnswer / listQuestions.size}"
        )
//        Toast.makeText(getApplication(), "result $result%", Toast.LENGTH_LONG).show()
    }

}