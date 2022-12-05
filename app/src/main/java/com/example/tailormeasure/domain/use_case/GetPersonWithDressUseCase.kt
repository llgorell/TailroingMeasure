package com.example.tailormeasure.domain.use_case

import com.example.tailormeasure.domain.relation.PersonWithDress
import com.example.tailormeasure.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow

class GetPersonWithDressUseCase(
    private val repository: PersonRepository
) {

    operator fun invoke(phone : String) : Flow<List<PersonWithDress>>{
       return repository.getDressesByPhone(phone)
    }
}