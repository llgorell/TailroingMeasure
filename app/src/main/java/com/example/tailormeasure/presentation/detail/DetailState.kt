package com.example.tailormeasure.presentation.detail

import com.example.tailormeasure.domain.model.Dress
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.model.SizeBody

data class DetailState(
    val person: Person? = null,
    val listDress: List<Dress> = emptyList(),
    val listSizeOfBody: List<SizeBody> = emptyList(),
)
