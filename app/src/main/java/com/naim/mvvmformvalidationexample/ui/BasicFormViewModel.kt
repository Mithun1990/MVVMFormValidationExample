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
        information.value?.let {
            if (it.validateName() != FormError.NO_ERROR) {
                formErrors.add(it.validateName())
            }
            if (it.validateEmail() != FormError.NO_ERROR) {
                formErrors.add(it.validateEmail())
            }
            if (it.validatePassword() != FormError.NO_ERROR) {
                formErrors.add(it.validatePassword())
            }
        }
        return formErrors.isEmpty()
    }

    enum class FormError {
        REQUIRED_NAME,
        REQUIRED_EMAIL,
        REQUIRED_PASSWORD,
        INVALID_EMAIL,
        INVALID_PASSWORD,
        NO_ERROR
    }
}