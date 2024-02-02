package com.BySandS.testsandquizes.presentation

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.BySandS.testsandquizes.DataBase.models.SubcategoryModel
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.CategoryItemFragmentBinding
import com.BySandS.testsandquizes.presentation.mainActivityModels.CategoryModel
import com.BySandS.testsandquizes.presentation.mainActivityModels.DifficultyNameModel

/**
 * Фрагмент для показа категорий тестов
 */
class CategoriesFragment() : Fragment() {

    private lateinit var testsRecyclerView: RecyclerView

    //подключаем VM фрагмента
    private val testListViewModel: TestsListViewModel by lazy {
        ViewModelProvider(this).get(TestsListViewModel::class.java)
    }
    private var difficultyNameModel = testListViewModel.difficultyNameModel
    private var adapter: CategoryAdapter? = CategoryAdapter(emptyList(), difficultyNameModel!!)

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
        val view = inflater.inflate(R.layout.categories_fragment, container, false)
        testsRecyclerView = view.findViewById(R.id.test_recycler_view)
        testsRecyclerView.layoutManager = LinearLayoutManager(context)
        testsRecyclerView.adapter = adapter
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testListViewModel.listCategoryModel.observe(
            viewLifecycleOwner,
            Observer { crimes ->
                crimes?.let {
                    Log.i(TAG, "Got crimes ${crimes.size}")
                    updateUI(crimes)
                }
            })
    }

    /**
     * Подключаем лист категорий из VM
     * Подключаем текст описания сложности из VM
     * Подключаем адаптер к RV
     */
    fun updateUI(subcategory: List<SubcategoryModel>) {
        val difficulty = testListViewModel.difficultyNameModel
        // -> !! Непонятно
        adapter = CategoryAdapter(subcategory, difficulty!!)
        testsRecyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = CategoriesFragment()
    }

    /**
     * class Holder
     */
    private inner class CategoryHolder(item: View) : RecyclerView.ViewHolder(item),
        View.OnClickListener {
        val binding = CategoryItemFragmentBinding.bind(item)
        lateinit var category: CategoryModel

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(
            categoryModel: CategoryModel,
            difficultyNameModel: DifficultyNameModel,
        ) = with(binding) {
            category = categoryModel
            val easyPercent = ": ${categoryModel.easyPercent}%"
            val normPercent = ": ${categoryModel.normPercent}%"
            val hardPercent = ": ${categoryModel.hardPercent}%"
            tvNameCategory.text = categoryModel.name
            tvEasy.text = difficultyNameModel.easy
            tvNorm.text = difficultyNameModel.norm
            tvHard.text = difficultyNameModel.hard
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
            Toast.makeText(context, "${category.name} pressed!", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * class Adapter
     */
    private inner class CategoryAdapter(
        var categories: List<CategoryModel>,
        var difficultyNameModel: DifficultyNameModel
    ) :
        RecyclerView.Adapter<CategoryHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item_fragment, parent, false)
            return CategoryHolder(view)
        }

        override fun getItemCount(): Int = categories.size

        override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
            holder.bind(categories[position], difficultyNameModel)
        }
    }
}