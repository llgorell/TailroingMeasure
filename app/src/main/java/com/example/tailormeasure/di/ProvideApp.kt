package com.example.tailormeasure.di

import com.example.tailormeasure.domain.use_case.util.ValidateInput
import com.example.tailormeasure.domain.use_case.util.ValidateNumber
import com.example.tailormeasure.domain.use_case.util.ValidatePhone
import com.example.tailormeasure.domain.use_case.util.Validation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProvideApp {

    @Binds
    @Singleton
    abstract fun bindValidateInput(validateInput: ValidateInput) : Validation

    @Binds
    @Singleton
    abstract fun bindPhoneValidate(validatePhone: ValidatePhone) : Validation

    @Binds
    @Singleton
    abstract fun bindNumberValidate(validatePhone: ValidateNumber) : Validation
}