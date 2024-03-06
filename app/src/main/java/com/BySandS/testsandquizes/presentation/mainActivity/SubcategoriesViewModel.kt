package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestSubcategoryAndStatisticUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

/**
 * Здесь должна быть вся логика работы с ЮзКейсами
 * Все действия из Активити должны делигироваться в ВМ, активити должна просто получать готовые данные и показывать их на экране!!!
 * Желательно чтобы ВМ не зависила от Андройдовских штук, что-то типо домена
 * !!!ВАЖНО!!! Во ВМ контекста быть не должно!
 * Один из вариантов - подать УзКейсы в конструктор, репозиторий нам не нужен,
 *      т.к. он служит для создания ЮзКейсов, в идеале это делается в DependencyInjection, но на данный момент можно использовать фабрику ВМ
 * !!!ГЛАВНОЕ ПРАВИЛО!!! -> ВМ не должно ничего возвращать! А Активити должно следить за изменениями в ВМ и как-то реагировать!
 * Данные мы сохраняем в MutableLiveData, а в Активити следим за ее изменением!
 * Из LiveData не надо отписываться, одписка происходит автоматически. Важно!!! - если в Активити вы подписались в onCreate - отписка произойдет в onDestroy,
 *      если подписались в  onResum ->  отписка в onPause!!!
 */
class SubcategoriesViewModel(private val getTestSubcategoryAndStatisticUseCase: GetTestSubcategoryAndStatisticUseCase) :
    ViewModel() {


    private val param = GetSubcategoryAndStatisticParam(idCategory = 1)
    private var listSubcategoryAndStatisticModelLiveData =
        MutableLiveData<List<SubcategoryAndStatisticModel>>()
    var listLiveData: LiveData<List<SubcategoryAndStatisticModel>> = listSubcategoryAndStatisticModelLiveData

    init {
        val idCategory = SubcategoriesFragment.requireArguments().getInt(SubcategoriesFragment.ARG_NAME)
        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch(Dispatchers.IO) {
            val list = getTestSubcategoryAndStatisticUseCase.execute(param)
            listSubcategoryAndStatisticModelLiveData.postValue(list)
        }
    }

    /**
     * Метод вызывается, когда связанная активити или фрагмент уничтожается
     * здесь делаем отписки
     */
    override fun onCleared() {
        super.onCleared()
    }
}





