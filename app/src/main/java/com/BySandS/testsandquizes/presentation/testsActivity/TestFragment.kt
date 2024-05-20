package com.BySandS.testsandquizes.presentation.testsActivity

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.TestFragmentBinding
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments.GetHintDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "AAA"

class TestFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: TestFragmentBinding
    private val testVM by viewModel<TestFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TestFragmentBinding.inflate(inflater, container, false)
        idSubcategory = requireArguments().getLong(ID_SUBCATEGORY_AND_STATISTIC)
        idDifficultyLevel = requireArguments().getLong(ID_DIFFICULTY_LEVEL)
        quantityOfQuestion = requireArguments().getInt(QUANTITY_OF_QUESTION)

//        val companyFlowResult = findNavController().currentBackStackEntry
//            ?.savedStateHandle
//            ?.remove<Boolean>(GetHintDialogFragment.COMPANY_FLOW_RESULT_FLAG)
//        if (companyFlowResult == true) {
//            Log.i(TAG, "companyFlowResult => $companyFlowResult")
//        }
//        Log.i(TAG, "companyFlowResult => $companyFlowResult")


        Log.i(TAG, "idSubcategory => $idSubcategory")
        Log.i(TAG, "idDifficultyLevel => $idDifficultyLevel")
        Log.i(TAG, "quantityOfQuestion => $quantityOfQuestion")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        btAnswer1.setOnClickListener(this@TestFragment)
        btAnswer2.setOnClickListener(this@TestFragment)
        btAnswer3.setOnClickListener(this@TestFragment)
        btAnswer4.setOnClickListener(this@TestFragment)
        btBack.setOnClickListener(this@TestFragment)
        btHelp.setOnClickListener(this@TestFragment)
        testVM.quantityOfHint.observe(
            viewLifecycleOwner, Observer { it ->
                it?.let {
                    val quantityOfHints = getString(
                        R.string.quantity_of_hint_TF,
                        testVM.quantityOfHint.value?.quantity.toString()
                    )
                    tvHintNumber.text = quantityOfHints
                }
            })

        testVM.question.observe(
            viewLifecycleOwner, Observer { question ->
                question?.let {
                    if (binding.constLayoutTestFragment.background == null) setBackground()
                    showQuestion(question = question)
                }
            })

        parentFragmentManager.setFragmentResultListener(
            TestResultDialogFragment.REQUEST_CODE,
            viewLifecycleOwner
        ) { _, data ->
            val clickResult = data.getInt(TestResultDialogFragment.BUTTON_RESULT)
            processingResultOfDialogFragment(clickResult = clickResult)
        }
        parentFragmentManager.setFragmentResultListener(
            GetHintDialogFragment.REQUEST_CODE,
            viewLifecycleOwner
        ) { _, data ->
            val clickResult = data.getInt(GetHintDialogFragment.BUTTON_CANCEL_POP_BACK_STACK)
            if (clickResult == 5) testVM.refreshQuantityOfHint()
            Log.i(TAG, "clickResult =============> $clickResult")
        }

    }

    companion object {
        fun newInstance() = TestFragment()
        var idSubcategory: Long = 0
        var idDifficultyLevel: Long = 0
        var quantityOfQuestion: Int = 0
        const val ID_SUBCATEGORY_AND_STATISTIC = "ID_SUBCATEGORY_AND_STATISTIC"
        const val ID_DIFFICULTY_LEVEL = "ID_DIFFICULTY_LEVEL"
        const val QUANTITY_OF_QUESTION = "QUANTITY_OF_QUESTION"
    }

    /**
     * Метод заполнения фрагмента
     * Сначала идет проверка все ли кнопки в режиме Enabled, если до этого была использована подсказка
     * Далее идет заполнения экрана данными из VM  с уже перемешанными результатами ответа
     */
    private fun showQuestion(question: QuestionModel) = with(binding) {
        Log.i(TAG, "------------------------------------------")

        if (!btAnswer1.isEnabled) btAnswer1.isEnabled = true
        if (!btAnswer2.isEnabled) btAnswer2.isEnabled = true
        if (!btAnswer3.isEnabled) btAnswer3.isEnabled = true
        if (!btAnswer4.isEnabled) btAnswer4.isEnabled = true


        val questionsNumbers =
            getString(
                R.string.number_of_question_TF,
                (testVM.numberOfQuestion.value!! + 1).toString(),
                testVM.questionList.value!!.size.toString()
            )

        tvQuestion.text = question.questionText
        tvQuestionsNumbers.text = questionsNumbers

        btAnswer1.text = question.correctAnswer
        btAnswer2.text = question.incorrectAnswer1
        btAnswer3.text = question.incorrectAnswer2
        btAnswer4.text = question.incorrectAnswer3
    }

    /**
     * В зависимости от нажатой кнопки - отправляет ответ на проверку
     * После последнего вопроса формирует данные для показа результата
     * и запускает диалоговый фрагмент с результатами теста
     */
    override fun onClick(v: View?): Unit =
        with(binding) {
            if (testVM.numberOfQuestion.value != testVM.questionList.value!!.size - 1) {
                when (v?.id) {
                    btAnswer1.id -> testVM.checkingAnswer(btAnswer1.text.toString())
                    btAnswer2.id -> testVM.checkingAnswer(btAnswer2.text.toString())
                    btAnswer3.id -> testVM.checkingAnswer(btAnswer3.text.toString())
                    btAnswer4.id -> testVM.checkingAnswer(btAnswer4.text.toString())
                }
            } else {
                val newStatisticResult = testVM.calculateResultStatistic()
                val bundle = testVM.getResult(newStatisticResult)
                findNavController().navigate(
                    R.id.action_testFragment_to_testResultDialogFragment, bundle
                )
            }
            when (v?.id) {
                btBack.id -> backAlertDialog()
                btHelp.id -> helpAlertDialog()
            }
        }

    /**
     * Обработка результата нажатия кнопок в ResultDialogFragment
     * Если нажата кнопка продолжить -> сохраняем статистику в БД в возвращаемся в фрагмент
     *      с выбором уровней сложности
     * При нажатии на кнопку "еще раз" вызываем метод resetTest который обнуляет значения текущего прохождения
     *      и начинает тест с начала
     */
    private fun processingResultOfDialogFragment(clickResult: Int) {
        when (clickResult) {
            1 -> {
                testVM.saveStatistic()
                findNavController().popBackStack()
                findNavController().popBackStack()
            }

            2 -> testVM.resetTest()
        }
    }

    /**
     * Метод использования подсказки
     * Заполняем лист неправильными ответами и перемешиваем его
     * Проверяем текст на кнопках с первым и вторым неправильными ответами,
     *      и если есть совпадение делаем кнопку некликабельной     *
     */
    private fun getHelp() = with(binding) {
        if (btAnswer1.isEnabled && btAnswer2.isEnabled && btAnswer3.isEnabled && btAnswer4.isEnabled) {
            var answer = arrayListOf(
                testVM.questionList.value!![testVM.numberOfQuestion.value!!].incorrectAnswer1,
                testVM.questionList.value!![testVM.numberOfQuestion.value!!].incorrectAnswer2,
                testVM.questionList.value!![testVM.numberOfQuestion.value!!].incorrectAnswer3
            ).shuffled()

            if (btAnswer1.text == answer[0] || btAnswer1.text == answer[1]) btAnswer1.isEnabled =
                false
            if (btAnswer2.text == answer[0] || btAnswer2.text == answer[1]) btAnswer2.isEnabled =
                false
            if (btAnswer3.text == answer[0] || btAnswer3.text == answer[1]) btAnswer3.isEnabled =
                false
            if (btAnswer4.text == answer[0] || btAnswer4.text == answer[1]) btAnswer4.isEnabled =
                false
            testVM.minusQuantityOfHint()
        } else {
            Toast.makeText(
                context,
                getString(R.string.hint_has_already_been_used),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setBackground() {
        when (testVM.subcategoryModel?.linkToBackground) {
            "space_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.space_background
            )

            "school_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.school_background
            )

            "nature_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.nature_background
            )

            "erudition_and_intelligence_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.erudition_and_intelligence_background
            )

            "movie_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.movie_background
            )

            "music_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.music_background
            )

            "leisure_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.leisure_background
            )

            "technologies_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.technologies_background
            )

            "sport_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.sport_background
            )

            "health_background.jpg" -> binding.constLayoutTestFragment.setBackgroundResource(
                R.drawable.health_background
            )
        }
    }

    private fun backAlertDialog() {
        val listener = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> findNavController().popBackStack()
            }
        }

        val alertDialog = AlertDialog.Builder(context)
            .setCancelable(false) // Отменяемый диалог, т.е. диалог нельзя отменить нажав мимо, или кнопкой назад
            .setIcon(R.drawable.baseline_cancel_24)
            .setTitle(getString(R.string.exite_from_test))
            .setMessage(getString(R.string.test_exit_confirmation))
            .setPositiveButton(R.string.yes, listener)
            .setNegativeButton(R.string.no, listener)
            .setOnCancelListener {
                // Метод сработает если .setCancelable(true) и мы нажали вне диалога. тогда сработает блок кода
            }
            .setOnDismissListener {
                // !!! Данный метод срабатывает всегда при закрытии диалога !!!
            }
            .create()
        alertDialog.show()
    }

    private fun helpAlertDialog() {
        if (testVM.quantityOfHint.value?.quantity != 0) {
            val listener = DialogInterface.OnClickListener { _, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        getHelp()
                    }
                }
            }

            val alertDialog = AlertDialog.Builder(context)
                .setCancelable(false) // Отменяемый диалог, т.е. диалог нельзя отменить нажав мимо, или кнопкой назад
                .setIcon(R.drawable.baseline_local_hospital_24)
                .setTitle(getString(R.string.get_help_tf))
                .setMessage(getString(R.string.get_help_confirmation_tf))
                .setPositiveButton(R.string.yes, listener)
                .setNegativeButton(R.string.no, listener)
                .setOnCancelListener {
                    // Метод сработает если .setCancelable(true) и мы нажали вне диалога. тогда сработает блок кода
                }
                .setOnDismissListener {
                    // !!! Данный метод срабатывает всегда при закрытии диалога !!!
                }
                .create()
            alertDialog.show()
        } else {
            val listener = DialogInterface.OnClickListener { _, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> findNavController().navigate(R.id.action_testFragment_to_get_hint)
                }
            }

            val alertDialog = AlertDialog.Builder(context)
                .setCancelable(false) // Отменяемый диалог, т.е. диалог нельзя отменить нажав мимо, или кнопкой назад
                .setIcon(R.drawable.baseline_local_hospital_24)
                .setTitle(getString(R.string.no_help))
                .setMessage(getString(R.string.no_help_discription))
                .setPositiveButton(R.string.yes, listener)
                .setNegativeButton(R.string.no, listener)
                .setOnCancelListener {
                    // Метод сработает если .setCancelable(true) и мы нажали вне диалога. тогда сработает блок кода
                }
                .setOnDismissListener {
                    // !!! Данный метод срабатывает всегда при закрытии диалога !!!
                }
                .create()
            alertDialog.show()
        }

    }
}