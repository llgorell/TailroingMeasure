package com.example.tailormeasure.domain.use_case

import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.repository.PersonRepository

class GetPersonUseCase(
    private val repository: PersonRepository
) {

    suspend operator fun invoke(phone : String) : Person?{
        return repository.getPersonByPhone(phone)
    }
}