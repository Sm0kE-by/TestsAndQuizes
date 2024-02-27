package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.SubcategoryItemFragmentBinding


private const val TAG = "AAA"

/**
 * Фрагмент для показа категорий тестов
 */
class SubcategoriesFragment() : Fragment() {

    private lateinit var testsRecyclerView: RecyclerView

    //подключаем VM фрагмента
    private val subcategory: SubcategoriesFragmentViewModel by lazy {
        ViewModelProvider(this).get(SubcategoriesFragmentViewModel::class.java)
    }
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
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "${subcategory.getList()}")
        //возможно надо вместо метода следить за объектом
        subcategory.getList().observe(
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
    fun updateUI(subcategory: List<com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel>) {
        adapter = SubcategoryAdapter(subcategory)
        testsRecyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = SubcategoriesFragment()
    }

    /**
     * class Holder
     */
    private inner class SubcategoryHolder(item: View) : RecyclerView.ViewHolder(item),
        View.OnClickListener {
        val binding = SubcategoryItemFragmentBinding.bind(item)
        lateinit var subcategory: com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(
            subcategoryModel: com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
        ) = with(binding) {
            subcategory = subcategoryModel
            val easyPercent = ": ${subcategoryModel.statisticEasyPercent}%"
            val normPercent = ": ${subcategoryModel.statisticNormPercent}%"
            val hardPercent = ": ${subcategoryModel.statisticHardPercent}%"
            tvNameSubcategory.text = subcategoryModel.subcategoryName
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
        var subcategories: List<com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel>,
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