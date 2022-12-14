package com.example.tailormeasure.presentation.person.add_eddit_person

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.use_case.PersonUseCase
import com.example.tailormeasure.domain.use_case.util.ValidateInput
import com.example.tailormeasure.domain.use_case.util.ValidatePhone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditPersonViewModel @Inject constructor(
    private val useCase: PersonUseCase,
    private val validateInput: ValidateInput,
    private val validatePhone: ValidatePhone,
     val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _name = mutableStateOf(
        TextFieldState(
            hint = "Enter your name"
        )
    )
    val name: State<TextFieldState> = _name

    private val _family = mutableStateOf(
        TextFieldState(
            hint = "Enter your family"
        )
    )
    val family: State<TextFieldState> = _family

    private val _phone = mutableStateOf(
        TextFieldState(
            hint = "09123456789"
        )
    )
    val phone: State<TextFieldState> = _phone

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentPhone: String? = null

    init {
        savedStateHandle.get<String>("phone")?.let {phone->
            if (phone.isNotBlank()){
                viewModelScope.launch {
                    useCase.getPerson(phone)?.also { person ->
                        currentPhone = person.phone
                        _name.value = name.value.copy(
                            text = person.name,
                            isHintVisible = false
                        )
                        _family.value = family.value.copy(
                            text = person.family,
                            isHintVisible = false
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditPersonEvent) {
        when (event) {
            is AddEditPersonEvent.EnteredName -> {
                _name.value = name.value.copy(
                    text = event.value
                )
            }
            is AddEditPersonEvent.ChangeNameFocus -> {
                _name.value = name.value.copy(
                    isHintVisible = !event.focusState.isFocused && name.value.text.isBlank()
                )
            }
            is AddEditPersonEvent.EnteredFamily -> {
                _family.value = family.value.copy(
                    text = event.value
                )

            }
            is AddEditPersonEvent.ChangeFamilyFocus -> {
                _family.value = family.value.copy(
                    isHintVisible = !event.focusState.isFocused && family.value.text.isBlank()
                )
            }
            is AddEditPersonEvent.EnteredPhone -> {
                _phone.value = phone.value.copy(
                    text = event.value
                )
            }
            is AddEditPersonEvent.ChangePhoneFocus -> {
                _phone.value = phone.value.copy(
                    isHintVisible = !event.focusState.isFocused && phone.value.text.isBlank()
                )
            }
            is AddEditPersonEvent.SavePerson -> {
                savePerson()
            }
        }
    }

    private fun savePerson() {
        val nameInput = validateInput.execute(name.value.text)
        val familyInput = validateInput.execute(family.value.text)
        val phoneInput = validatePhone.execute(phone.value.text)

        val hasError = listOf(
            nameInput,
            familyInput,
            phoneInput
        ).any { !it.successful }
        if (hasError) {
            _name.value = name.value.copy(
                errorMessage = nameInput.errorMessage
            )
            _family.value = family.value.copy(
                errorMessage = familyInput.errorMessage
            )
            _phone.value = phone.value.copy(
                errorMessage = phoneInput.errorMessage
            )
            return
        }
        _name.value = name.value.copy(
            errorMessage = null
        )
        _family.value = family.value.copy(
            errorMessage = null
        )
        _phone.value = phone.value.copy(
            errorMessage = null
        )
        viewModelScope.launch {
            try {
                useCase.addPerson(
                    Person(
                        name = name.value.text,
                        family = family.value.text,
                        phone = currentPhone ?: phone.value.text,
                    )
                )
                _name.value = name.value.copy(
                    text = "",
                )
                _family.value = family.value.copy(
                    text = "",
                )
                _phone.value = phone.value.copy(
                    text = "",
                )
                _eventFlow.emit(UiEvent.SavePerson)
            }catch (e : Exception){
                _eventFlow.emit(UiEvent.ShowSnackBar(
                    message = e.message ?: "couldnt save person"
                ))
            }

        }

    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        object SavePerson : UiEvent()
    }
}