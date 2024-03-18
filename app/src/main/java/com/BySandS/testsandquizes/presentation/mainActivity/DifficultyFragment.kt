package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.DefficultyFragmentBinding
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.presentation.testsActivity.TestFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "AAA"

class DifficultyFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: DefficultyFragmentBinding
    private val difficultyVM by viewModel<DifficultyFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DefficultyFragmentBinding.inflate(inflater, container, false)
        //      idQuantityOfQuestion = requireArguments().getLong(ID_QUANTITY_OF_QUESTION)
        idSubcategoryAndStatistic = requireArguments().getLong(ID_SUBCATEGORY_AND_STATISTIC)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardView1.setOnClickListener(this@DifficultyFragment)
        binding.cardView2.setOnClickListener(this@DifficultyFragment)
        binding.cardView3.setOnClickListener(this@DifficultyFragment)
        difficultyVM.quantityOfQuestions.observe(
            viewLifecycleOwner, Observer { quantity ->
                quantity?.let {
                    updateUI(quantity, difficultyVM.subcategoryAndStatisticModel.value!!)
                }
            })
    }


    companion object {
        //        @JvmStatic
//        fun newInstance() = DifficultyFragment()
        //       var idQuantityOfQuestion: Long = 0
        var idSubcategoryAndStatistic: Long = 0
        const val ID_QUANTITY_OF_QUESTION = "ID_QUANTITY_OF_QUESTION"
        const val ID_SUBCATEGORY_AND_STATISTIC = "SUBCATEGORY_AND_STATISTIC"
    }

    private fun updateUI(
        quantityOfQuestions: QuantityOfQuestionModel,
        subcategoryAndStatisticModel: SubcategoryModel
    ) = with(binding) {

        //получаю из БД кол-во вопросов
        tvQuantityQuestionEasy.text = quantityOfQuestions.easyQuantity.toString()
        tvQuantityQuestionNorm.text = quantityOfQuestions.normQuantity.toString()
        tvQuantityQuestionHard.text = quantityOfQuestions.hardQuantity.toString()
        // получаю из БД статистика
        tvBestResultEasyNamber.text = subcategoryAndStatisticModel.statisticEasy.toString()
        tvBestResultNormNamber.text = subcategoryAndStatisticModel.statisticNorm.toString()
        tvBestResultHardNamber.text = subcategoryAndStatisticModel.statisticHard.toString()
        tvNameSubcategory.text = subcategoryAndStatisticModel.name
    }

    override fun onClick(v: View?): Unit = with(binding) {
        when (v?.id) {
            //Убрать метод вызова активити в ВМ
            cardView1.id -> startActivityTest(1L)
            cardView2.id -> startActivityTest(2L)
            cardView3.id -> startActivityTest(3L)
        }
    }

    private fun startActivityTest(idDifficult: Long) {
        var quantityOfQuestions = 0
        difficultyVM.quantityOfQuestions.observe(
            viewLifecycleOwner, Observer { quantity ->
                quantity?.let {
                    when (idDifficult){
                        1L ->  quantityOfQuestions = it.easyQuantity
                        2L ->  quantityOfQuestions = it.normQuantity
                        3L ->  quantityOfQuestions = it.hardQuantity
                    }

                }
            })
        Log.i(TAG, "quantityOfQuestions 1111 => $quantityOfQuestions")
        val idSubcategory = idSubcategoryAndStatistic
//        val testActivity = Intent(activity, TestActivity::class.java)
//        startActivity(testActivity)
        findNavController().navigate(
            R.id.action_difficultyFragment_to_testFragment,
            bundleOf(
                TestFragment.ID_SUBCATEGORY_AND_STATISTIC to idSubcategory,
                TestFragment.ID_DIFFICULTY_LEVEL to idDifficult,
                TestFragment.QUANTITY_OF_QUESTION to quantityOfQuestions
            )
        )
    }
}