package com.naim.mvvmformvalidationexample.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.naim.mvvmformvalidationexample.BR
import com.naim.mvvmformvalidationexample.ui.BasicFormViewModel

class Information : BaseObservable() {
    @Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @Bindable
    var email: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    @Bindable
    var password: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }

    fun validateName(): BasicFormViewModel.FormError {
        return if (name.isNullOrEmpty())
            BasicFormViewModel.FormError.REQUIRED_NAME
        else
            BasicFormViewModel.FormError.NO_ERROR
    }

    fun validateEmail(): BasicFormViewModel.FormError {
        return if (email.isNullOrEmpty())
            BasicFormViewModel.FormError.REQUIRED_EMAIL
        else
            BasicFormViewModel.FormError.NO_ERROR
    }

    fun validatePassword(): BasicFormViewModel.FormError {
        return if (password.isNullOrEmpty())
            BasicFormViewModel.FormError.REQUIRED_PASSWORD
        else
            BasicFormViewModel.FormError.NO_ERROR
    }
}