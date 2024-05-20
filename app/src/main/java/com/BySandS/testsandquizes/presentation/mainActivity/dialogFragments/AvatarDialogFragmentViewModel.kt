package com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.domain.allData.models.AvatarModel

class AvatarDialogFragmentViewModel : ViewModel() {

    // private var listAvatarsMutable = MutableLiveData<List<AvatarModel>>()
    // val listAvatars: LiveData<List<AvatarModel>> = listAvatarsMutable
    val listAvatars: List<AvatarModel> = initListAvatar()
    private var avatarIconMutable = MutableLiveData<AvatarModel>()
    private var buttonDonIsEnableMutable = MutableLiveData<Boolean>(false)
    var avatarIcon: LiveData<AvatarModel> = avatarIconMutable
    var buttonDonIsEnable: LiveData<Boolean> = buttonDonIsEnableMutable
   // var avatarIcon = AvatarModel("avatar_4.png", "standart", "Desc 1", true)

    init {
        avatarIconMutable.value = AvatarModel(1,"avatar_4.png", "standart", "Desc 1", true)
    }

    private fun initListAvatar(): List<AvatarModel> {
        val list = ArrayList<AvatarModel>()
        list.add(0, AvatarModel(1,"avatar_1.png", "standart", "Desc 1", true))
        list.add(1, AvatarModel(2,"avatar_2.png", "standart", "Desc 2", true))
        list.add(2, AvatarModel(3,"avatar_3.png", "standart", "Desc 3", true))
        list.add(3, AvatarModel(4,"avatar_4.png", "standart", "Desc 4", true))
        list.add(4, AvatarModel(5,"avatar_5.png", "standart", "Desc 5", true))
        list.add(5, AvatarModel(6,"avatar_6.png", "standart", "Desc 6", false))
        list.add(6, AvatarModel(7,"avatar_7.png", "standart", "Desc 7", false))
        list.add(7, AvatarModel(8,"avatar_8.png", "standart", "Desc 8", false))
        list.add(8, AvatarModel(9,"avatar_9.png", "standart", "Desc 9", false))
        list.add(9, AvatarModel(10,"avatar_10.png", "standart", "Desc 10", false))
        return list
    }

    fun setAvatar(avatar: AvatarModel){
        avatarIconMutable.value = avatar
    }
    fun setDoneIsEnable(isClickable: Boolean){
        buttonDonIsEnableMutable.value = isClickable
    }
}