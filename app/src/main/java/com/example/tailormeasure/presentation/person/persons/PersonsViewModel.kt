package com.example.tailormeasure.presentation.person.persons

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.use_case.PersonUseCase
import com.example.tailormeasure.domain.use_case.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(
    private val personUseCase: PersonUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PersonState())
    val state: State<PersonState> = _state

    private val _query = mutableStateOf(
        SearchQueryState(
            hintQuery = "جستجو..."
        )
    )
    val query: State<SearchQueryState> = _query

    private var recentlyDeletePerson: Person? = null

    private var searchJob : Job? = null

    init {
        getPersonBySearch(OrderType.Ascending)
    }

    fun onEvent(event : PersonEvent){
        when(event){
            is PersonEvent.DeletePerson -> {
                viewModelScope.launch {
                    personUseCase.deletePerson(person = event.person)
                    recentlyDeletePerson = event.person
                }
            }
            is PersonEvent.OrderType -> {
                if (state.value.orderType::class == event.orderType::class)
                    return
                getPersonBySearch(event.orderType)
            }
            is PersonEvent.CallPerson -> {
                //TODO call Person
            }
            is PersonEvent.SmsPerson -> {

                //TODO sms Person
            }
            is PersonEvent.EnteredQuery ->{
              _query.value = query.value.copy(
                  query = event.query
              )
              getPersonBySearch(state.value.orderType)
            }
            is PersonEvent.ChangeQueryFocus -> {
                _query.value = query.value.copy(
                    isVisibleHint = !event.focusState.isFocused && query.value.query.isBlank()
                )
            }
            is PersonEvent.RestorePerson -> {
                viewModelScope.launch {
                    personUseCase.addPerson( person = recentlyDeletePerson ?: return@launch)
                    recentlyDeletePerson = null
                }
            }
            is PersonEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
            is PersonEvent.ToggleTabStatusPerson -> {
                when(event.statusPerson){
                    is StatusPerson.Debt ->{
                      state.value.personList.map { it.inDebt }
                    }
                    is StatusPerson.Completed ->{
                        state.value.personList.map { !it.inDebt }
                    }
                }
            }

        }
    }
    private fun getPersonBySearch(orderType: OrderType){
        searchJob?.cancel()
        searchJob = personUseCase.searchPerson(orderType,query.value.query).onEach {
            _state.value = state.value.copy(
                personList = it ,
                orderType = orderType
            )
        }.launchIn(viewModelScope)
    }

    fun getPersonalWithDebt(){

    }
}