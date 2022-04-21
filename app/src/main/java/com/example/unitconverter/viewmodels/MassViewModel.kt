package com.example.unitconverter.viewmodels

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unitconverter.R

class MassViewModel : ViewModel() {
    private val _unitmass: MutableLiveData<Int> = MutableLiveData(R.string.kg)

    val unit: LiveData<Int>
        get() = _unitmass

    fun setUnit(value: Int) {
        _unitmass.value = value
    }

    private val _mass: MutableLiveData<String> = MutableLiveData("")

    val mass: LiveData<String>
        get() = _mass

    fun getMassAsFloat(): Float = (_mass.value ?: "").let {
        return try {
            it.toFloat()
        } catch (e: NumberFormatException) {
            Float.NaN
        }
    }

    fun setMass(value: String) {
        _mass.value = value
    }

    fun convert() = getMassAsFloat().let {
        if (!it.isNaN())
            if (_unitmass.value == R.string.kg)
                it * 2.20462262F
            else
                it / 2.20462262F
        else
            Float.NaN
    }
}