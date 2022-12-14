package com.example.tailormeasure.domain.use_case

data class PersonUseCase(
    val addPerson : AddPersonUseCase,
    val searchPerson : SearchUseCase,
    val deletePerson : DeletePersonUseCase,
    val getPerson : GetPersonUseCase,
    val getPersonWithDress : GetPersonWithDressUseCase,
    val addDress : AddDressUseCase,
    val addSize : AddSizeBodyUseCase
)
