package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.allData.models.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.models.GameCompletionPercentageModel
import com.BySandS.testsandquizes.domain.allData.models.PlayerNameModel
import com.BySandS.testsandquizes.domain.allData.models.PrestigeModel
import com.BySandS.testsandquizes.domain.allData.models.QuantityOfGemsModel
import com.BySandS.testsandquizes.domain.allData.models.QuantityOfHintModel
import com.BySandS.testsandquizes.domain.allData.useCase.GetQuantityOfHintUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainMenuViewModel(
    private val getQuantityOfHintUseCase: GetQuantityOfHintUseCase,
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
       // viewModelScope.launch(Dispatchers.IO) {
            gemsMutable.postValue(QuantityOfGemsModel(110))
            quantityOfHintMutable.postValue(getQuantityOfHintUseCase.execute())
            prestigeMutable.postValue(PrestigeModel(1100))
            gameCompletionPercentageMutable.postValue(GameCompletionPercentageModel(25))
            playerNameMutable.postValue(PlayerNameModel("Smoke.by"))
            avatarIconMutable.postValue(AvatarModelForMainMenu(1, "avatar_1.png"))


      //  }

    }


}