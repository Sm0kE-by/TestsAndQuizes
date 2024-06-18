package com.BySandS.testsandquizes.presentation.mainActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.GameCompletionPercentageModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.PlayerNameModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.PrestigeModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.QuantityOfGemsModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.QuantityOfHintModel
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.GetAvatarForMainMenuUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.GetQuantityOfHintUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class MainMenuViewModel(
    private val getQuantityOfHintUseCase: GetQuantityOfHintUseCase,
    private val getAvatarForMainMenuUseCase: GetAvatarForMainMenuUseCase,
) : ViewModel() {

    private val gemsMutable = MutableLiveData<QuantityOfGemsModel>()
    private val quantityOfHintMutable = MutableLiveData<QuantityOfHintModel>()
    private val prestigeMutable = MutableLiveData<PrestigeModel>()
    private val gameCompletionPercentageMutable = MutableLiveData<GameCompletionPercentageModel>()
    private val playerNameMutable = MutableLiveData<PlayerNameModel>()
    private val avatarIconMutable = MutableLiveData<AvatarModelForMainMenu>()

    val gems: LiveData<QuantityOfGemsModel> = gemsMutable
    val quantityOfHint: LiveData<QuantityOfHintModel> = quantityOfHintMutable
    val prestige: LiveData<PrestigeModel> = prestigeMutable
    val gameCompletionPercentage: LiveData<GameCompletionPercentageModel> =
        gameCompletionPercentageMutable
    val playerName: LiveData<PlayerNameModel> = playerNameMutable
    val avatarIcon: LiveData<AvatarModelForMainMenu> = avatarIconMutable

    init {

        viewModelScope.launch(Dispatchers.IO) {
            gemsMutable.postValue(QuantityOfGemsModel(110))
            prestigeMutable.postValue(PrestigeModel(1100))
            gameCompletionPercentageMutable.postValue(GameCompletionPercentageModel(25))

            playerNameMutable.postValue(PlayerNameModel("Smoke.by"))

            quantityOfHintMutable.postValue(getQuantityOfHintUseCase.execute())
            loadAvatarFromSP()


        }

    }

    fun loadAvatarFromSP() {
        avatarIconMutable.postValue(getAvatarForMainMenuUseCase.execute())
        Log.i(TAG, "loadAvatarFromSP 1111 => loadAvatarFromSP")
        // Log.i(TAG, "LOAD AVATAR 1111 => id = ${avatarIcon.value!!.id} ICON = ${avatarIcon.value!!.avatarIcon}")
    }

}