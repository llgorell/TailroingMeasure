package com.example.tailormeasure.domain.use_case.util

interface Validation {
    fun execute(input : String) : ValidateResult
}