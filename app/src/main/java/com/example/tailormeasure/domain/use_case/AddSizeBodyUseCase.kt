package com.example.tailormeasure.domain.use_case

import com.example.tailormeasure.domain.model.SizeBody
import com.example.tailormeasure.domain.repository.PersonRepository

class AddSizeBodyUseCase(
    private val repository: PersonRepository
) {

    suspend operator fun invoke(size : SizeBody){
        repository.insertSizeBody(size)
    }
}