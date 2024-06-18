package com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModel
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.GetAvatarByIdParam
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.GetAvatarByIdUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.GetListAvatarsUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.SaveAvatarSPUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

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
        Log.i(TAG, "SAVE AVATAR 1111 => id = ${avatarIcon.value!!.id} ICON = ${avatarIcon.value!!.avatarIcon}")
        val param = SaveAvatarSharedPrefParam(id = avatarIcon.value!!.id, avatarIcon = avatarIcon.value!!.avatarIcon)
        saveAvatarSPUseCase.execute(saveAvatarSharedPrefParam = param)
        Log.i(TAG, "saveAvatarSharedPref 1111 => saveAvatarSharedPref")

    }

    fun setAvatar(avatar: AvatarModel) {
        avatarIconMutable.value = avatar
    }

    fun setDoneIsEnable(isClickable: Boolean) {
        buttonDonIsEnableMutable.value = isClickable
    }
}