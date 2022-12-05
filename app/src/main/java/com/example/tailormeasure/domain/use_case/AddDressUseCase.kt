package com.example.tailormeasure.domain.use_case

import com.example.tailormeasure.domain.model.Dress
import com.example.tailormeasure.domain.repository.PersonRepository

class AddDressUseCase(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(dress : Dress) {
        repository.insertDress(dress)
    }
}