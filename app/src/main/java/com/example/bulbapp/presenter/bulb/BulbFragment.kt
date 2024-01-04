package com.example.bulbapp.presenter.bulb

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bulbapp.R
import com.example.bulbapp.UiState
import com.example.bulbapp.data.repository.model.BulbBrightnessLevel
import com.example.bulbapp.data.repository.model.Color
import com.example.bulbapp.databinding.FragmentBulbBinding
import com.example.bulbapp.di.appComponent
import com.example.bulbapp.di.viewModel.ViewModelFactory
import com.google.android.material.slider.Slider
import javax.inject.Inject

class BulbFragment : Fragment(R.layout.fragment_bulb) {

    private val binding: FragmentBulbBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: BulbViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.brightnessLevelLiveData.observe(viewLifecycleOwner) {
            onBrightnessLevelDataReceived(it)
        }
        viewModel.loadBrightnessLevel()

        viewModel.colorNamesLiveData.observe(viewLifecycleOwner) {
            onColorNamesDataReceived(it)
        }

        viewModel.currentColorLiveData.observe(viewLifecycleOwner) {
            onCurrentColorDataReceived(it)
        }

        viewModel.currentBrightnessLevelLiveData.observe(viewLifecycleOwner) {
            onCurrentBrightnessLevelDataReceived(it)
        }

        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            onStateDateReceived(it)
        }
        viewModel.loadState()

        initHandlers()
    }

    private fun onCurrentColorDataReceived(currentColor: UiState<Color?>?){
        when(currentColor) {
            is UiState.Success -> {
                binding.autoCompleteText.isEnabled = true
                currentColor.value?.let {
                    binding.autoCompleteText.setText(it.color.lowercase())
                }
            }
            is UiState.Failure -> {
                binding.autoCompleteText.isEnabled = false
            }
            is UiState.Loading -> {
                binding.autoCompleteText.isEnabled = false
            }
            else -> {}
        }
    }

    private fun onCurrentBrightnessLevelDataReceived(brightnessLevel: UiState<Int?>?) {
        when(brightnessLevel) {
            is UiState.Success -> {
                binding.brightnessSlider.isEnabled = true
                brightnessLevel.value?.let {
                    binding.brightnessSlider.value = it.toFloat()
                }
            }
            is UiState.Failure -> {
                binding.brightnessSlider.isEnabled = false
            }
            is UiState.Loading -> {
                binding.brightnessSlider.isEnabled = false
            }
            else -> {}
        }
    }

    private fun onColorNamesDataReceived(colorNames: UiState<List<String>?>?) {
        when(colorNames) {
            is UiState.Success -> {
                binding.autoCompleteText.isEnabled = true
                colorNames.value?.let {
                    val colorsAdapter = ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_dropdown_item,
                        it)
                    binding.autoCompleteText.setAdapter(colorsAdapter)
                }
            }
            is UiState.Failure -> {
                binding.autoCompleteText.isEnabled = false
            }
            is UiState.Loading -> {
                binding.autoCompleteText.isEnabled = false
            }
            else -> {}
        }
    }

    private fun onBrightnessLevelDataReceived(brightnessLevel: UiState<BulbBrightnessLevel?>?) {
        when(brightnessLevel) {
            is UiState.Success -> {
                binding.brightnessSlider.isEnabled = true
                brightnessLevel.value?.let {
                    binding.brightnessSlider.valueFrom = it.min.toFloat()
                    binding.brightnessSlider.valueTo = it.max.toFloat()
                    binding.brightnessSlider.stepSize = it.precision.toFloat()
                }
            }
            is UiState.Failure -> {
                binding.brightnessSlider.isEnabled = false
            }
            is UiState.Loading -> {
                binding.brightnessSlider.isEnabled = false
            }
            else -> {}
        }
    }

    private fun onStateDateReceived(state: UiState<Boolean?>?) {
        when(state) {
            is UiState.Success -> {
                binding.onOffSwitch.isEnabled = true
                state.value?.let {
                    setTextSwitch(it)
                    binding.onOffSwitch.isChecked = it
                    setVisibility(it)
                }
            }
            is UiState.Failure -> {
                binding.onOffSwitch.isEnabled = false
            }
            is UiState.Loading -> {
                binding.onOffSwitch.isEnabled = false
            }
            else -> {}
        }
    }

    private fun initHandlers() {
        initSwitch()
        initSeekBar()
        initSpinner()
    }

    private fun initSpinner() {
        binding.autoCompleteText.setOnItemClickListener { _, _, position, _ ->
            val item = binding.autoCompleteText.adapter.getItem(position)
            viewModel.setColor(item.toString())
        }
    }

    private fun initSwitch() {
        binding.onOffSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            setTextSwitch(isChecked)
            viewModel.setState(isChecked)
            setVisibility(isChecked)
            if (isChecked) loadCurrentState()
        }
    }

    private fun initSeekBar() {
        binding.brightnessSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {}
            override fun onStopTrackingTouch(slider: Slider) {
                viewModel.setBrightnessLevel(slider.value.toInt())
            }
        })
    }

    private fun loadCurrentState() {
        viewModel.loadCurrentBrightnessLevel()
        viewModel.loadCurrentColor()
        viewModel.loadColorNames()
    }

    private fun setVisibility(isVisible: Boolean) {
        if (isVisible) {
            binding.autoCompleteText.visibility = View.VISIBLE
            binding.brightnessSlider.visibility = View.VISIBLE
            binding.textInputLayout.visibility = View.VISIBLE
        } else{
            binding.autoCompleteText.visibility = View.GONE
            binding.brightnessSlider.visibility = View.GONE
            binding.textInputLayout.visibility = View.GONE
        }
    }

    private fun setTextSwitch(isChecked: Boolean) {
        if(isChecked){
            binding.onOffSwitch.text = "ON"
        }else{
            binding.onOffSwitch.text = "OFF"
        }
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

}