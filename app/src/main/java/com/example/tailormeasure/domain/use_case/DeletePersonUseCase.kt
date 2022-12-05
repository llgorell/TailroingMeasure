package com.example.tailormeasure.domain.use_case

import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.repository.PersonRepository

class DeletePersonUseCase(
    private val repository: PersonRepository
) {

   suspend  operator fun invoke(person: Person){
       repository.deletePerson(person)
   }
}