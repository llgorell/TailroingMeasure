package com.example.tailormeasure.domain.use_case.util

data class ValidateResult(
    val successful : Boolean,
    val errorMessage : String? = null
)
