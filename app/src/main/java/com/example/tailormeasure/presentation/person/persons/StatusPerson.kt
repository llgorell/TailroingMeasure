package com.example.tailormeasure.presentation.person.persons

sealed class StatusPerson{
    object Debt : StatusPerson()
    object Completed : StatusPerson()
}
