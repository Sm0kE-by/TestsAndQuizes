package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.SubcategoryItemFragmentBinding
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import org.koin.androidx.viewmodel.ext.android.viewModel


private const val TAG = "AAA"

/**
 * Фрагмент для показа категорий тестов
 */
class SubcategoriesFragment() : Fragment() {

    private lateinit var testsRecyclerView: RecyclerView
    private val subcategoryVM by viewModel<SubcategoriesViewModel>()
    private var adapter: SubcategoryAdapter? = SubcategoryAdapter(emptyList())

    /**
     * Надуваем Фрагмент
     * Надуваем RV
     * Указываем отображение RV в виде списка(вертикального)
     * Загружаем настройки адаптера
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.subcategories_fragment, container, false)
        testsRecyclerView = view.findViewById(R.id.test_recycler_view)
        testsRecyclerView.layoutManager = LinearLayoutManager(context)
        testsRecyclerView.adapter = adapter
      //  val idCategory = requireArguments().getInt(ARG_NAME)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        subcategoryVM.listLiveData.observe(
            viewLifecycleOwner,
            Observer { subcategories ->
                subcategories?.let {
                    Log.i(TAG, "Got crimes ${subcategories.size}")
                    updateUI(subcategories)
                }
            })
    }

    /**
     * Подключаем лист категорий из VM
     * Подключаем текст описания сложности из VM
     * Подключаем адаптер к RV
     */
    fun updateUI(subcategory: List<SubcategoryAndStatisticModel>) {
        adapter = SubcategoryAdapter(subcategory)
        testsRecyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = SubcategoriesFragment()
        //name поменять, это для практики, наз объекта
        const val ARG_NAME = "name"
        const val REQUEST_CODE = "REQUEST_CODE"
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }

    /**
     * class Holder
     */
    private inner class SubcategoryHolder(item: View) : RecyclerView.ViewHolder(item),
        View.OnClickListener {
        val binding = SubcategoryItemFragmentBinding.bind(item)
        lateinit var subcategory: SubcategoryAndStatisticModel

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(
            subcategoryAndStatisticModel: SubcategoryAndStatisticModel
        ) = with(binding) {
            subcategory = subcategoryAndStatisticModel
            val easyPercent = ": ${subcategoryAndStatisticModel.statisticEasyPercent}%"
            val normPercent = ": ${subcategoryAndStatisticModel.statisticNormPercent}%"
            val hardPercent = ": ${subcategoryAndStatisticModel.statisticHardPercent}%"
            tvNameSubcategory.text = subcategoryAndStatisticModel.subcategoryName
            tvPercentEasy.text = easyPercent
            tvPercentNorm.text = normPercent
            tvPercentHard.text = hardPercent
        }

        /**
         * Обработка нажатия на фрагмент категории
         */
        override fun onClick(v: View?) {
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.holder, DifficultyFragment.newInstance()).commit()
            Toast.makeText(context, "${subcategory.subcategoryName} pressed!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    /**
     * class Adapter
     */
    private inner class SubcategoryAdapter(
        var subcategories: List<SubcategoryAndStatisticModel>,
    ) :
        RecyclerView.Adapter<SubcategoryHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.subcategory_item_fragment, parent, false)
            return SubcategoryHolder(view)
        }

        override fun getItemCount(): Int = subcategories.size
        override fun onBindViewHolder(holder: SubcategoryHolder, position: Int) {
            holder.bind(subcategories[position])
        }
    }
}