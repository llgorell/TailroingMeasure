package com.example.tailormeasure.presentation.person.add_eddit_person

data class TextFieldState(
    val text : String = "",
    val hint : String = "",
    val isError : Boolean = false,
    val errorMessage : String? = null,
    val isHintVisible : Boolean = true
)