package com.naim.mvvmformvalidationexample.ui

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naim.mvvmformvalidationexample.model.Information

class BasicFormViewModel : ViewModel() {
    val information = MutableLiveData<Information>().apply {
        this.value = Information()
    }
    val formErrors = ObservableArrayList<FormError>()

    fun printValue() {
        println("${information.value?.name} ${information.value?.email} ${information.value?.password}")
    }

    fun isFormValid(): Boolean {
        formErrors.clear()
        if (information.value?.name.isNullOrEmpty())
            formErrors.add(FormError.REQUIRED_NAME)
        if (information.value?.email.isNullOrEmpty())
            formErrors.add(FormError.REQUIRED_EMAIL)
        if (information.value?.password.isNullOrEmpty())
            formErrors.add(FormError.REQUIRED_PASSWORD)
        return formErrors.isEmpty()
    }

    enum class FormError {
        REQUIRED_NAME,
        REQUIRED_EMAIL,
        REQUIRED_PASSWORD,
        INVALID_EMAIL,
        INVALID_PASSWORD
    }
}