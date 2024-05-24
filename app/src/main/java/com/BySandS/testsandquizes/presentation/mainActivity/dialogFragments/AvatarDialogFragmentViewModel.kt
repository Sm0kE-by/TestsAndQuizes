package com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.allData.models.AvatarModel
import com.BySandS.testsandquizes.domain.allData.models.param.GetAvatarByIdParam
import com.BySandS.testsandquizes.domain.allData.models.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.useCase.GetAvatarByIdUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.GetListAvatarsUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.SaveOpenAvatarDbUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.SaveAvatarSPUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AvatarDialogFragmentViewModel(
    private val getListAvatarsUseCase: GetListAvatarsUseCase,
    private val getAvatarByIdUseCase: GetAvatarByIdUseCase,
    private val saveAvatarSPUseCase: SaveAvatarSPUseCase,
) : ViewModel() {

    private var listAvatarsMutable = MutableLiveData<List<AvatarModel>>()
    private var avatarIconMutable = MutableLiveData<AvatarModel>()
    private var buttonDonIsEnableMutable = MutableLiveData<Boolean>(false)

    val listAvatars: LiveData<List<AvatarModel>> = listAvatarsMutable
    var avatarIcon: LiveData<AvatarModel> = avatarIconMutable
    var buttonDonIsEnable: LiveData<Boolean> = buttonDonIsEnableMutable


    init {
        viewModelScope.launch(Dispatchers.IO) {
            listAvatarsMutable.postValue(getListAvatarsUseCase.execute())
        }
    }

    fun setAvatarById(id: Long) {
        val param = GetAvatarByIdParam(id = id)
        viewModelScope.launch(Dispatchers.IO) {
            avatarIconMutable.postValue(getAvatarByIdUseCase.execute(param = param))
        }
    }

    fun saveAvatarSharedPref(){
        val param = SaveAvatarSharedPrefParam(avatarIcon.value!!.id, avatarIcon.value!!.name)
        saveAvatarSPUseCase.execute(saveAvatarSharedPrefParam = param)
    }

    fun setAvatar(avatar: AvatarModel) {
        avatarIconMutable.value = avatar
    }

    fun setDoneIsEnable(isClickable: Boolean) {
        buttonDonIsEnableMutable.value = isClickable
    }
}