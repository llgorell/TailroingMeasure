package com.example.tailormeasure.presentation.person.persons

import androidx.compose.ui.focus.FocusState
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.use_case.util.OrderType

sealed class PersonEvent{
    data class DeletePerson(val person: Person) :PersonEvent()
    data class OrderType(val orderType: com.example.tailormeasure.domain.use_case.util.OrderType) :PersonEvent()
    data class CallPerson(val number : String) : PersonEvent()
    data class SmsPerson(val number : String) : PersonEvent()
    data class EnteredQuery(val query : String) : PersonEvent()
    data class ChangeQueryFocus(val focusState: FocusState) : PersonEvent()
    data class ToggleTabStatusPerson(val statusPerson: StatusPerson) : PersonEvent()
    object RestorePerson : PersonEvent()
    object ToggleOrderSection : PersonEvent()
}


