package com.BySandS.testsandquizes.presentation.testsActivity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.allData.models.QuantityOfHintModel
import com.BySandS.testsandquizes.domain.allData.models.param.SaveQuantityOfHintParam
import com.BySandS.testsandquizes.domain.allData.useCase.GetQuantityOfHintUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.SaveQuantityOfHintUseCase
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetResultParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryByIdParam
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.UpdateTestSubcategoryUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestSubcategoryByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class TestFragmentViewModel(
    private val getTestResultUseCase: GetTestResultUseCase,
    private val getQuestionListUseCase: GetQuestionListUseCase,
    private val getTestSubcategoryByIdUseCase: GetTestSubcategoryByIdUseCase,
    private val updateTestSubcategoryUseCase: UpdateTestSubcategoryUseCase,
    private val getQuantityOfHintUseCase: GetQuantityOfHintUseCase,
    private val saveQuantityOfHintUseCase: SaveQuantityOfHintUseCase
) : ViewModel() {

    private val idSubcategory = TestFragment.idSubcategory
    private val idDifficultyLevel = TestFragment.idDifficultyLevel
    private val quantityOfQuestionMax = TestFragment.quantityOfQuestion

    private val questionListMutable = MutableLiveData<List<QuestionModel>>()
    private var numberOfQuestionMutable = MutableLiveData<Int>(0)
    private var questionMutable = MutableLiveData<QuestionModel>()
    private val quantityOfHintMutable = MutableLiveData<QuantityOfHintModel>()
    private val resultMutable = MutableLiveData<ResultTestModel>()

    val questionList: LiveData<List<QuestionModel>> = questionListMutable
    var numberOfQuestion: LiveData<Int> = numberOfQuestionMutable
    var question: LiveData<QuestionModel> = questionMutable
    val quantityOfHint: LiveData<QuantityOfHintModel> = quantityOfHintMutable
    private val result: LiveData<ResultTestModel> = resultMutable

    private var quantityCorrectAnswer = 0
    var subcategoryModel: SubcategoryModel? = null

    private val getQuestionListParam = GetQuestionListParam(
        difficultyId = idDifficultyLevel,
        quantityOfQuestions = quantityOfQuestionMax
    )

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val getSubcategoryByIdParam = GetSubcategoryByIdParam(idSubcategory = idSubcategory)
            subcategoryModel =
                getTestSubcategoryByIdUseCase.execute(param = getSubcategoryByIdParam)

            subcategoryModel.let {
                val getResultParam =
                    GetResultParam(
                        subcategoryId = subcategoryModel!!.id,
                        difficultyId = idDifficultyLevel
                    )
                questionListMutable.postValue(getQuestionListUseCase.execute(getQuestionListParam))

                quantityOfHintMutable.postValue( getQuantityOfHintUseCase.execute())
                while (questionList.value == null) {
                    Thread.sleep(10L)
                }
                questionMutable.postValue(
                    randomAnswerOfQuestion(questionList.value!![numberOfQuestion.value!!])
                )
                resultMutable.postValue(getTestResultUseCase.execute(getResultParam))
            }
        }
    }

    /**
     * Вычисление статистики пройденного теста
     */
    fun calculateResultStatistic(): Int {
        val correctAnswer: Double = quantityCorrectAnswer.toDouble()
        val listSize: Double = questionList.value!!.size.toDouble()
        return ((correctAnswer / listSize) * 100).toInt()
    }

    /**
     * Перемешивание ответов в вопросе
     */
    private fun randomAnswerOfQuestion(questionModel: QuestionModel): QuestionModel {
        Log.i(TAG, "Starting fun - randomAnswerOfQuestion")
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
        if (answerText == questionList.value!![numberOfQuestion.value!!].correctAnswer) {
            quantityCorrectAnswer++
        }
        updateNumberQuestion()
    }

    /**
     * Функция считает номер вопроса, увеличивает его на 1 и перемешивает ответы и записывает в вопрос
     */
    private fun updateNumberQuestion() {
        if (numberOfQuestion.value != questionList.value!!.size - 1) {
            val num: Int = numberOfQuestionMutable.value!! + 1
            numberOfQuestionMutable.value = num
            val question1 = questionList.value!![numberOfQuestionMutable.value!!]
            questionMutable.value = randomAnswerOfQuestion(question1)
        }
    }

    /**
     * Сохранение статистики
     * data Class StatisticModel - переменные типа VAR!!!!!!!!!!!!
     * if() в when()!!!!!
     */
    fun saveStatistic() {
        val newStatistic = calculateResultStatistic()
        Log.i(TAG, "New Statistic - $newStatistic")
        Log.i(TAG, "OLD subcategoryModel - ${subcategoryModel?.statisticEasy.toString()}")
        if (idDifficultyLevel == 1L && newStatistic > subcategoryModel!!.statisticEasy) subcategoryModel!!.statisticEasy =
            newStatistic
        if (idSubcategory == 2L && newStatistic > subcategoryModel!!.statisticNorm) subcategoryModel!!.statisticNorm =
            newStatistic
        if (idSubcategory == 3L && newStatistic > subcategoryModel!!.statisticHard) subcategoryModel!!.statisticHard =
            newStatistic
        if (idSubcategory == 4L && newStatistic > subcategoryModel!!.statisticVeryHard) subcategoryModel!!.statisticVeryHard =
            newStatistic
        Log.i(TAG, "NEW subcategoryModel - ${subcategoryModel?.statisticEasy.toString()}")
        viewModelScope.launch(Dispatchers.IO) {
            updateTestSubcategoryUseCase.execute(subcategoryModel!!)
        }
    }

    /**
     *
     */
    fun getResult(newStatistic: Int): Bundle {
        val bundle = Bundle()
        val quantityCorrAnswer = quantityCorrectAnswer
        val quantityOfQuestion = questionList.value!!.size
        val description: String

        //составляем описание результата
        if (newStatistic <= 33) description = result.value?.resultText33Ru.toString()
        else if (newStatistic <= 66) description = result.value?.resultText66Ru.toString()
        else if (newStatistic <= 99) description = result.value?.resultText99Ru.toString()
        else description = result.value?.resultText100Ru.toString()

        bundle.putInt(TestResultDialogFragment.KEY_STATISTIC, newStatistic)
        bundle.putInt(TestResultDialogFragment.KEY_CORRECT_ANSWER, quantityCorrAnswer)
        bundle.putInt(TestResultDialogFragment.KEY_QUANTITY_OF_QUESTION, quantityOfQuestion)
        bundle.putString(TestResultDialogFragment.KEY_SUBTITLE, description)
        return bundle
    }

    fun resetTest() {
        viewModelScope.launch(Dispatchers.IO) {
            questionListMutable.postValue(getQuestionListUseCase.execute(getQuestionListParam))
        }
        numberOfQuestionMutable.value = 0
        quantityCorrectAnswer = 0
        questionMutable.postValue(randomAnswerOfQuestion(questionList.value!![numberOfQuestion.value!!]))
    }

    fun minusQuantityOfHint() {
        saveQuantityOfHintUseCase.execute(
            saveQuantityOfHintParam = SaveQuantityOfHintParam(
                quantity = quantityOfHintMutable.value?.quantity!!.minus(1)
            )
        )
        quantityOfHintMutable.postValue( getQuantityOfHintUseCase.execute())
    }

    fun refreshQuantityOfHint(){
        quantityOfHintMutable.postValue( getQuantityOfHintUseCase.execute())
    }
}