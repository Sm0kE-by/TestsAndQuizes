package com.BySandS.testsandquizes.presentation.mainActivity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.BySandS.testsandquizes.databinding.DefficultyFragmentBinding
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.presentation.testsActivity.TestActivity
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
                    difficultyVM.subcategoryAndStatisticModel.observe(
                        viewLifecycleOwner,
                        Observer { subcategory ->
                            subcategory?.let { updateUI(quantity, subcategory) }
                        })
                }
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = DifficultyFragment()
    }

    private fun updateUI(quantityOfQuestions: QuantityOfQuestionModel, subcategoryAndStatisticModel: SubcategoryAndStatisticModel) = with(binding) {

        //получаю из БД кол-во вопросов
        tvQuantityQuestionEasy.text = quantityOfQuestions.easyQuantity.toString()
        tvQuantityQuestionNorm.text = quantityOfQuestions.normQuantity.toString()
        tvQuantityQuestionHard.text = quantityOfQuestions.hardQuantity.toString()
        // получаю из БД статистика
        tvBestResultEasyNamber.text = subcategoryAndStatisticModel.statisticEasyPercent.toString()
        tvBestResultNormNamber.text = subcategoryAndStatisticModel.statisticNormPercent.toString()
        tvBestResultHardNamber.text = subcategoryAndStatisticModel.statisticHardPercent.toString()
        tvNameSubcategory.text = subcategoryAndStatisticModel.subcategoryName
    }

    override fun onClick(v: View?): Unit = with(binding) {
        when (v?.id) {
            //Убрать метод вызова активити в ВМ
            cardView1.id -> startActivityTest()
            cardView2.id -> startActivityTest()
            cardView3.id -> startActivityTest()
        }
    }

    private fun startActivityTest() {
        val testActivity = Intent(activity, TestActivity::class.java)
        startActivity(testActivity)
    }
}