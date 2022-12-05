package com.example.tailormeasure.domain.use_case.util

import javax.inject.Inject

class ValidateInput @Inject constructor() : Validation {
    override fun execute(input: String): ValidateResult {
        if (input.isBlank()){
            return ValidateResult(
                successful = false,
                errorMessage = "the input cant Blank"
            )
        }
        return ValidateResult(
            successful = true
        )
    }
}