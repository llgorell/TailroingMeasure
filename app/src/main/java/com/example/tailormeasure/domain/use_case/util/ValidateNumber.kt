package com.example.tailormeasure.domain.use_case.util

import javax.inject.Inject

class ValidateNumber @Inject constructor() : Validation {
    override fun execute(input: String): ValidateResult {

        if (input.isBlank()){
            return ValidateResult(
                errorMessage = "cant be blank",
                successful = false
            )
        }
        val isDigitAndLetter = input.any{it.isLetter()}
        if (isDigitAndLetter){
            return ValidateResult(
                errorMessage = "cant be use letter",
                successful = false
            )
        }
        return ValidateResult(
            successful = true
        )
    }
}