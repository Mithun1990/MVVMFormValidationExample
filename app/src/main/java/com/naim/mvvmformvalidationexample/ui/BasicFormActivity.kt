package com.naim.mvvmformvalidationexample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.naim.mvvmformvalidationexample.databinding.ActivityBasicFormBinding

class BasicFormActivity : AppCompatActivity() {
    val binding: ActivityBasicFormBinding by lazy { ActivityBasicFormBinding.inflate(layoutInflater) }
    val vm: BasicFormViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.vm = vm
        binding.executePendingBindings()

        binding.btnValidate.setOnClickListener {
            if (vm.isFormValid()) {
                vm.printValue()
            }
        }

    }
}