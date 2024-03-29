package com.BySandS.testsandquizes.presentation.testsActivity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.TestFragmentBinding
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "AAA"

class TestFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: TestFragmentBinding
    private var dialog: DialogFragment = TestResultDialogFragment()

    //подключаем VM фрагмента
    private val testVM by viewModel<TestFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TestFragmentBinding.inflate(inflater, container, false)
        idSubcategory = requireArguments().getLong(ID_SUBCATEGORY_AND_STATISTIC)
        idDifficultyLevel = requireArguments().getLong(ID_DIFFICULTY_LEVEL)
        quantityOfQuestion = requireArguments().getInt(QUANTITY_OF_QUESTION)
        Log.i(TAG, "idSubcategory => $idSubcategory")
        Log.i(TAG, "idDifficultyLevel => $idDifficultyLevel")
        Log.i(TAG, "quantityOfQuestion => $quantityOfQuestion")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btAnswer1.setOnClickListener(this@TestFragment)
        binding.btAnswer2.setOnClickListener(this@TestFragment)
        binding.btAnswer3.setOnClickListener(this@TestFragment)
        binding.btAnswer4.setOnClickListener(this@TestFragment)
        binding.btBack.setOnClickListener(this@TestFragment)
        binding.btHelp.setOnClickListener(this@TestFragment)
        testVM.quantityOfHint.observe(
            viewLifecycleOwner, Observer { it ->
                it?.let {
                    testVM.question.observe(viewLifecycleOwner, Observer { question ->
                        Log.i(
                            TAG,
                            "questionListMutable2 ->>> ${testVM.questionList.value.toString()}"
                        )
                        Log.i(TAG, "question ->>> ${question.toString()}")
                        question?.let {
                            showQuestion(
                                question = question
                            )
                        }
                    })
                }
            }
        )
        parentFragmentManager.setFragmentResultListener(
            TestResultDialogFragment.REQUEST_CODE,
            viewLifecycleOwner
        ) { _, data ->
            val number = data.getInt(TestResultDialogFragment.BUTTON_RESULT)
            processingResultOfDialogFragment(number)
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

    private fun showQuestion(question: QuestionModel) = with(binding) {
        Log.i(TAG, "------------------------------------------")
        //Hint deleted!!!
        val quantityOfHints = "${testVM.quantityOfHint.value} из 3"
        tvHintNumber.text = quantityOfHints
        //русский текст!!!
        // ПРОВЕРИТЬ!!!
        val questionsNumbers =
            "${testVM.numberOfQuestion.value!! + 1} из ${testVM.questionList.value!!.size}"
        tvQuestion.text = question.questionText
        // Ответы уже перемешаны
        btAnswer1.text = question.correctAnswer
        btAnswer2.text = question.incorrectAnswer1
        btAnswer3.text = question.incorrectAnswer2
        btAnswer4.text = question.incorrectAnswer3

        tvQuestionsNumbers.text = questionsNumbers
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
                    btBack.id -> {
                        findNavController().popBackStack()
                    }

                    btHelp.id -> {
                        getHelp()
                    }
                }
            } else {
                val newStatisticResult = testVM.calculateResultStatistic()
                val bundle = testVM.getResult(newStatisticResult)
                findNavController().navigate(
                    R.id.action_testFragment_to_testResultDialogFragment, bundle
                )
            }
        }

    /**
     * Обработка результата нажатия кнопок в ResultDialogFragment
     */
    private fun processingResultOfDialogFragment(num: Int) {
        when (num) {
            1 -> {
                testVM.saveStatistic()
                findNavController().popBackStack()
            }

            2 -> testVM.resetTest()

        }
    }

    private fun getHelp() {
        var answer = ArrayList<String>()

        val list = listOf(1, 2, 3).shuffled()
        for (i in 0..1) {
            when (list[i]) {
                1 -> answer.add(i, testVM.question.value?.incorrectAnswer1.toString())
                2 -> answer.add(i, testVM.question.value?.incorrectAnswer2.toString())
                3 -> answer.add(i, testVM.question.value?.incorrectAnswer3.toString())
            }
        }
        Log.i(TAG, " answer -> ${answer.toString()}")
        
    }
}