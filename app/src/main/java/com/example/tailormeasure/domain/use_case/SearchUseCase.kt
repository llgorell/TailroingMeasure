package com.example.tailormeasure.domain.use_case

import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.repository.PersonRepository
import com.example.tailormeasure.domain.use_case.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SearchUseCase(
    private val repository: PersonRepository
) {
    operator fun invoke(
        orderType: OrderType = OrderType.Ascending,
        query : String
    ): Flow<List<Person>> {
        return repository.searchQuery(query).map { person ->

            when(orderType){
                is OrderType.Ascending -> {
                    person.sortedBy { it.name.lowercase() }
                }
                is OrderType.Descending -> {
                    person.sortedByDescending { it.name.lowercase() }
                }
            }

        }
    }
}