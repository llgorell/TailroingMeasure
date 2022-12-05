package com.example.tailormeasure.domain.use_case.util

import javax.inject.Inject

class ValidatePhone @Inject constructor() : Validation {
    override fun execute(input: String): ValidateResult {
        if (input.isBlank()){
            return ValidateResult(
                successful = false,
                errorMessage = "the phone number cant be blank"
            )
        }
        if (input.length < 11 || input.length > 11){
            return ValidateResult(
                successful = false,
                errorMessage = "the phone number must be 11 char"
            )
        }
        if (!input.startsWith("0")){
            return ValidateResult(
                successful = false,
                errorMessage = "the phone number must start with 0"
            )
        }
        return ValidateResult(
            successful = true
        )
    }
}