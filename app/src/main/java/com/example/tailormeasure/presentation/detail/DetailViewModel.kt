package com.example.tailormeasure.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tailormeasure.domain.use_case.PersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase : PersonUseCase,
   val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(DetailState())
    val state :State<DetailState> = _state

    init {
        savedStateHandle.get<String>("phone")?.let {
            getPersonWithDress(it)
        }
    }

    private fun getPersonWithDress(phone : String){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getPersonWithDress(phone).collect(){ head->
                head.forEach { list->
                    _state.value = state.value.copy(
                        person =list.person,
                        listDress = list.dresses
                    )
                }
            }
        }
    }
}
