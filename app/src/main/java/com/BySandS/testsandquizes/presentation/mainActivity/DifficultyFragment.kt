package com.BySandS.testsandquizes.presentation.mainActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.DefficultyFragmentBinding
import com.BySandS.testsandquizes.presentation.testsActivity.TestActivity

private const val TAG = "AAA"

class DifficultyFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: DefficultyFragmentBinding

    //подключаем VM фрагмента
    private val difficulty: DifficultyFragmentViewModel by lazy {
        ViewModelProvider(this).get(DifficultyFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DefficultyFragmentBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
        binding.cardView1.setOnClickListener(this@DifficultyFragment)
        binding.cardView2.setOnClickListener(this@DifficultyFragment)
        binding.cardView3.setOnClickListener(this@DifficultyFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DifficultyFragment()
    }

    private fun updateUI() = with(binding) {

        val subcategoryModel = difficulty.getCategory()
        val quantityOfQuestion = difficulty.getQuantityOfQuestion()
        Log.e(TAG, "${quantityOfQuestion.id} ${quantityOfQuestion.easyQuantity} ${quantityOfQuestion.normQuantity} ${quantityOfQuestion.hardQuantity} Проверка4")

        //получаю из БД кол-во вопросов
        tvQuantityQuestionEasy.text = quantityOfQuestion.easyQuantity.toString()
        tvQuantityQuestionNorm.text = quantityOfQuestion.normQuantity.toString()
        tvQuantityQuestionHard.text = quantityOfQuestion.hardQuantity.toString()
        // получаю из БД статистика
        tvBestResultEasyNamber.text = subcategoryModel.statisticEasyPercent.toString()
        tvBestResultNormNamber.text = subcategoryModel.statisticNormPercent.toString()
        tvBestResultHardNamber.text = subcategoryModel.statisticHardPercent.toString()
        tvNameSubcategory.text = subcategoryModel.subcategoryName
    }

    override fun onClick(v: View?): Unit = with(binding){
       when(v?.id){
           cardView1.id -> startActivityTest()
           cardView2.id -> startActivityTest()
           cardView3.id -> startActivityTest()


           else -> {}
       }
    }
    private fun startActivityTest(){
        val testActivity = Intent(activity, TestActivity::class.java)
        startActivity(testActivity)
    }
}