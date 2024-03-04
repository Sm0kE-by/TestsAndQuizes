package com.BySandS.testsandquizes.presentation.testsActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetResultParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetStatisticParam
import com.BySandS.testsandquizes.domain.tests.usecase.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestStatisticUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.SaveTestStatisticUseCase
import com.BySandS.testsandquizes.presentation.model.TestModelPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class TestFragmentViewModel(
    private val getTestResultUseCase: GetTestResultUseCase,
    private val getQuestionListUseCase: GetQuestionListUseCase,
    private val saveTestStatisticUseCase: SaveTestStatisticUseCase,
    private val getTestStatisticUseCase: GetTestStatisticUseCase
) : ViewModel() {

    //private val questionListMutable = MutableLiveData<List<QuestionModel>>()

    private val result = MutableLiveData<ResultTestModel>()
    private val static = MutableLiveData<StatisticModel>()

    //Пока вручную, потом буду принимать его на вход
    val testModelPresentation =
        TestModelPresentation(nameSubcategoryId = 1, difficultyId = 1, quantityOfQuestion = 7)

    val listQuestions: List<QuestionModel> = listOf(
        QuestionModel(
            1,
            "QuestionText 1",
            "Correct Answer 1",
            "Incorrect Answer 1 - 1",
            "Incorrect Answer 1 - 2",
            "Incorrect Answer 1 - 3"
        ),
        QuestionModel(
            2,
            "QuestionText 2",
            "Correct Answer 2",
            "Incorrect Answer 2 - 1",
            "Incorrect Answer 2 - 2",
            "Incorrect Answer 2 - 3"
        ),
        QuestionModel(
            3,
            "QuestionText 3",
            "Correct Answer 3",
            "Incorrect Answer 3 - 1",
            "Incorrect Answer 3 - 2",
            "Incorrect Answer 3 - 3"
        ),
        QuestionModel(
            4,
            "QuestionText 4",
            "Correct Answer 4",
            "Incorrect Answer 4 - 1",
            "Incorrect Answer 4 - 2",
            "Incorrect Answer 4 - 3"
        ),
        QuestionModel(
            5,
            "QuestionText 5",
            "Correct Answer 5",
            "Incorrect Answer 5 - 1",
            "Incorrect Answer 5 - 2",
            "Incorrect Answer 5 - 3"
        ),
        QuestionModel(
            6,
            "QuestionText 6",
            "Correct Answer 6",
            "Incorrect Answer 6 - 1",
            "Incorrect Answer 6 - 2",
            "Incorrect Answer 6 - 3"
        ),
        QuestionModel(
            7,
            "QuestionText 7",
            "Correct Answer 7",
            "Incorrect Answer 7 - 1",
            "Incorrect Answer 7 - 2",
            "Incorrect Answer 7 - 3"
        ),
    )
    private val questionListMutable = MutableLiveData<List<QuestionModel>>(listQuestions)
    val questionList: LiveData<List<QuestionModel>> = questionListMutable

    //Или подгружать новый, или принимать на вход выбранный, пока руками написал
    var statisticModel =
        StatisticModel(1, "Cosmos", 30, 60, 90)

    //количество подсказок пока руками, модельки еще нет
    var quantityOfHint = 2
    var quantityCorrectAnswer = 0
    var quantityOfQuestion = 0
    private var quantityOfQuestionMutable = MutableLiveData<Int>(quantityOfQuestion)

    //Для инициализации
    val getQuestionListParam = GetQuestionListParam(difficultyId = 1, quantityOfQuestions = 1)
    val getResultParam = GetResultParam(testResultId = 1, difficultyId = 1)
    val getStatisticParam = GetStatisticParam(nameSubcategory = "cosmos")

    private var questionMutable =
        MutableLiveData<QuestionModel>(randomAnswerOfQuestion(listQuestions[quantityOfQuestion]))
    var question: LiveData<QuestionModel> = questionMutable

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //questionList.postValue(getQuestionListUseCase.execute(param = getQuestionListParam))
            //  questionListMutable.value = listQuestions
            result.postValue(getTestResultUseCase.execute(param = getResultParam))
            static.postValue(getTestStatisticUseCase.execute(param = getStatisticParam))
        }
    }

    /**
     * Вычисление статистики пройденного теста
     */
    private fun calculateTheResult(): Int {
        Log.i(TAG, "calculateTheResult")
        val correctAnswer: Double = quantityCorrectAnswer.toDouble()
        val listSize: Double = listQuestions.size.toDouble()
        return ((correctAnswer / listSize) * 100).toInt()
    }

    /**
     * Перемешивание ответов в вопросе
     */
    private fun randomAnswerOfQuestion(questionModel: QuestionModel): QuestionModel {
        Log.i(TAG, "randomAnswerOfQuestion")
        val list = listOf(
            questionModel.correctAnswer,
            questionModel.incorrectAnswer1,
            questionModel.incorrectAnswer2,
            questionModel.incorrectAnswer3
        ).shuffled()
        return QuestionModel(
            id = questionModel.id,
            questionText = questionModel.questionText,
            correctAnswer = list[0],
            incorrectAnswer1 = list[1],
            incorrectAnswer2 = list[2],
            incorrectAnswer3 = list[3]
        )
    }

    /**
     * Проверка правильности ответа
     */
    fun checkingAnswer(answerText: String) {
        Log.i(TAG, "Starting fun - checkingAnswer")
        Log.i(
            TAG,
            "answerText = $answerText; correctAnswer = ${listQuestions[quantityOfQuestion].correctAnswer}"
        )
        if (answerText == listQuestions[quantityOfQuestion].correctAnswer) {
            quantityCorrectAnswer++
            Log.i(TAG, "CorrectAnswer - $answerText")
        } else {
        }
        updateParam()
    }

    private fun updateParam() {
        Log.i(TAG, "Starting fun - updateParam")

        if (quantityOfQuestion != listQuestions.size-1) {
            ++quantityOfQuestion
            val question1 = listQuestions[quantityOfQuestion]
            Log.i(TAG, "$question1")
            Log.i(TAG, "getQuestion $quantityOfQuestion listQuestions.size ${listQuestions.size}")
            questionMutable.value = randomAnswerOfQuestion(question1)
        } else {
            Log.i(TAG, "saveStatistic")
//            when (testModelPresentation.difficultyId) {
//                1L -> saveTestStatisticUseCase.execute(
//                    StatisticModel(
//                        id = static.value!!.id,
//                        nameSubcategory = static.value!!.nameSubcategory,
//                        easy = calculateTheResult(),
//                        norm = static.value!!.norm,
//                        hard = static.value!!.hard
//                    )
//                )
//
//                2L -> saveTestStatisticUseCase.execute(
//                    StatisticModel(
//                        id = static.value!!.id,
//                        nameSubcategory = static.value!!.nameSubcategory,
//                        easy = static.value!!.easy,
//                        norm = calculateTheResult(),
//                        hard = static.value!!.hard
//                    )
//                )
//
//                3L -> saveTestStatisticUseCase.execute(
//                    StatisticModel(
//                        id = static.value!!.id,
//                        nameSubcategory = static.value!!.nameSubcategory,
//                        easy = static.value!!.easy,
//                        norm = static.value!!.norm,
//                        hard = calculateTheResult()
//                    )
//                )
//            }
        }
    }
}