package com.example.tailormeasure.presentation.person.persons

data class SearchQueryState(
    val query: String = "",
    val hintQuery: String = "",
    val isVisibleHint: Boolean = true
)