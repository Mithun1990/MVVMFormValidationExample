package com.naim.mvvmformvalidationexample.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.naim.mvvmformvalidationexample.BR

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
}