package com.naim.mvvmformvalidationexample.ui.adapter

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.naim.mvvmformvalidationexample.R

@BindingAdapter("requiredErrorText")
fun setRequiredFieldError(textInputLayout: TextInputLayout, isError: Boolean) {
    textInputLayout.error =
        if (isError) textInputLayout.resources.getString(R.string.required_field) else null
}