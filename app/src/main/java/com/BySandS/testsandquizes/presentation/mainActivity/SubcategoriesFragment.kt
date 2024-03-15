package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.SubcategoryItemFragmentBinding
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModelForSubcategoryFragment
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
        idCategory = requireArguments().getLong(ARG_NAME)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        subcategoryVM.listLiveData.observe(
            viewLifecycleOwner,
            Observer { subcategories ->
                subcategories?.let {
                    updateUI(subcategories)
                }
            })
    }

    /**
     * Подключаем лист категорий из VM
     * Подключаем текст описания сложности из VM
     * Подключаем адаптер к RV
     */
    fun updateUI(subcategory: List<SubcategoryModelForSubcategoryFragment>) {
        adapter = SubcategoryAdapter(subcategory)
        testsRecyclerView.adapter = adapter
    }

    companion object {
//        @JvmStatic
//        fun newInstance() = SubcategoriesFragment()

        //name поменять, это для практики, наз объекта
        var idCategory: Long = 1
        const val ARG_NAME = "ARG_NAME"
    }

    /**
     * class Holder
     */
    private inner class SubcategoryHolder(item: View) : RecyclerView.ViewHolder(item),
        View.OnClickListener {
        val binding = SubcategoryItemFragmentBinding.bind(item)
        lateinit var subcategory: SubcategoryModelForSubcategoryFragment

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(
            subcategoryModel: SubcategoryModelForSubcategoryFragment
        ) = with(binding) {
            subcategory = subcategoryModel
            val easyPercent = ": ${subcategoryModel.statisticEasy}%"
            val normPercent = ": ${subcategoryModel.statisticNorm}%"
            val hardPercent = ": ${subcategoryModel.statisticHard}%"
            tvNameSubcategory.text = subcategoryModel.name
            tvPercentEasy.text = easyPercent
            tvPercentNorm.text = normPercent
            tvPercentHard.text = hardPercent
            //Проверка на наличие вери хард режима
            //if() tvPercentHard.text = hardPercent
            when (subcategory.linkToIcon) {
                "space_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.space_icon)
                "school_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.school_icon)
                "nature_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.nature_icon)
                "erudition_and_intelligence_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.erudition_and_intelligence_icon)
                "movie_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.movie_icon)
                "music_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.music_icon)
                "leisure_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.leisure_icon)
                "technologies_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.technologies_icon)
                "sport_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.sport_icon)
                "health_icon.jpg" -> constLayMain.setBackgroundResource(R.drawable.health_icon)
            }
        }

        /**
         * Обработка нажатия на фрагмент категории
         */
        override fun onClick(v: View?) {
            val idSubcategory = subcategory.id
            findNavController().navigate(
                R.id.action_subcategoriesFragment_to_difficultyFragment,
                bundleOf(
                    DifficultyFragment.ID_SUBCATEGORY_AND_STATISTIC to idSubcategory
                )
            )
        }
    }

    /**
     * class Adapter
     */
    private inner class SubcategoryAdapter(
        var subcategories: List<SubcategoryModelForSubcategoryFragment>,
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