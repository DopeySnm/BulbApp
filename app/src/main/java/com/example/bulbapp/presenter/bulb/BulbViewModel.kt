package com.example.bulbapp.presenter.bulb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bulbapp.UiState
import com.example.bulbapp.data.repository.model.BulbBrightnessLevel
import com.example.bulbapp.data.repository.model.Color
import com.example.bulbapp.domain.*
import com.example.bulbapp.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class BulbViewModel @Inject constructor(
    private val getCurrentColorUseCase: GetCurrentColorUseCase,
    private val getColorNamesBulbUseCase: GetColorNamesBulbUseCase,
    private val getBrightnessLevelUseCase: GetBrightnessLevelUseCase,
    private val getStateBulbUseCase: GetStateBulbUseCase,
    private val getCurrentBrightnessLevelUseCase: GetCurrentBrightnessLevelUseCase,
    private val setStateBulbUseCase: SetStateBulbUseCase,
    private val setBrightnessLevelUseCase: SetBrightnessLevelUseCase,
    private val setColorBulbUseCase: SetColorBulbUseCase
) : ViewModel() {

    private val _currentColorLiveData = MutableLiveData<UiState<Color?>>(UiState.Loading)
    val currentColorLiveData: LiveData<UiState<Color?>>
        get() = _currentColorLiveData

    private val _colorNamesLiveData = MutableLiveData<UiState<List<String>?>>(UiState.Loading)
    val colorNamesLiveData: LiveData<UiState<List<String>?>>
        get() = _colorNamesLiveData

    private val _stateLiveData = MutableLiveData<UiState<Boolean?>>(UiState.Loading)
    val stateLiveData: LiveData<UiState<Boolean?>>
        get() = _stateLiveData

    private val _brightnessLevelLiveData = MutableLiveData<UiState<BulbBrightnessLevel?>>(UiState.Loading)
    val brightnessLevelLiveData: LiveData<UiState<BulbBrightnessLevel?>>
        get() = _brightnessLevelLiveData

    private val _currentBrightnessLevelLiveData = MutableLiveData<UiState<Int?>>()
    val currentBrightnessLevelLiveData: LiveData<UiState<Int?>>
        get() = _currentBrightnessLevelLiveData

    fun loadCurrentColor() {
        viewModelScope.launch {
            val result = getCurrentColorUseCase()
            _currentColorLiveData.postValue(result.toUiState())
        }
    }

    fun loadColorNames() {
        viewModelScope.launch {
            val result = getColorNamesBulbUseCase()
            _colorNamesLiveData.postValue(result.toUiState())
        }
    }

    fun loadState() {
        viewModelScope.launch {
            val result = getStateBulbUseCase()
            _stateLiveData.postValue(result.toUiState())
        }
    }

    fun loadBrightnessLevel() {
        viewModelScope.launch {
            val result = getBrightnessLevelUseCase()
            _brightnessLevelLiveData.postValue(result.toUiState())
        }
    }

    fun loadCurrentBrightnessLevel() {
        viewModelScope.launch {
            val result = getCurrentBrightnessLevelUseCase()
            _currentBrightnessLevelLiveData.postValue(result.toUiState())
        }
    }

    fun setBrightnessLevel(level: Int) {
        viewModelScope.launch {
            setBrightnessLevelUseCase(level)
        }
    }

    fun setColor(color: String) {
        viewModelScope.launch {
            setColorBulbUseCase(color)
        }
    }

    fun setState(state: Boolean) {
        viewModelScope.launch {
            setStateBulbUseCase(state)
        }
    }
}