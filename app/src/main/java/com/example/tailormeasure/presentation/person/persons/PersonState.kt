package com.example.tailormeasure.presentation.person.persons

import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.use_case.util.OrderType

data class PersonState(
   val personList : List<Person> = emptyList(),
   val orderType: OrderType = OrderType.Ascending,
   val isOrderSectionVisible : Boolean = false,

)
