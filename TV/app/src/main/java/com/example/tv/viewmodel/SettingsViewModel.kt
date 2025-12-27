package com.example.tv.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

class SettingsViewModel:ViewModel() {

    private var _selectContextFlow = MutableStateFlow("配置")
    val selectContextFlow = _selectContextFlow.asSharedFlow()

    private val _toastFlow = MutableStateFlow("")
    val toastFlow = _toastFlow.asSharedFlow()

    fun updateSelectContext(context:String){
        _selectContextFlow.value = context
    }

    fun updateToast(text:String){
        _toastFlow.value = text
    }

}