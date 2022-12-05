package com.example.tailormeasure.presentation.dress

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tailormeasure.domain.model.Dress
import com.example.tailormeasure.domain.use_case.PersonUseCase
import com.example.tailormeasure.domain.use_case.util.ValidateInput
import com.example.tailormeasure.domain.use_case.util.ValidateNumber
import com.example.tailormeasure.presentation.person.add_eddit_person.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddDressViewModel @Inject constructor(
    private val useCase: PersonUseCase,
    savedStateHandle: SavedStateHandle,
    private val validateInput: ValidateInput,
    private val validateNumber: ValidateNumber,
) : ViewModel() {

    private val _name = mutableStateOf(TextFieldState(
        hint = "name of dress"
    ))
    val name: State<TextFieldState> = _name

    private val _price = mutableStateOf(TextFieldState(
        hint = "The price of clothes"
    ))
    val price: State<TextFieldState> = _price

    private val _paid = mutableStateOf(TextFieldState(
        hint = "amount paid"
    ))
    val paid: State<TextFieldState> = _paid

    private val _accountBalance = mutableStateOf(TextFieldState(
        hint = "baghimande hesab"
    ))
    val accountBalance: State<TextFieldState> = _accountBalance

    private val _startDate = mutableStateOf(TextFieldState(
        hint = "start date "
    ))
    val startDate: State<TextFieldState> = _startDate

    private val _deliveryDate = mutableStateOf(TextFieldState(
        hint = "delivery date "
    ))
    val deliveryDate: State<TextFieldState> = _deliveryDate

    private val _notPaid = mutableStateOf(false)
    val notPaid: State<Boolean> = _notPaid

    private var currentId: Int? = null
    var phone: String = ""

    private val _eventSharedFlow = MutableSharedFlow<UiEvent>()
    val eventSharedFlow = _eventSharedFlow.asSharedFlow()

    init {
        savedStateHandle.get<String>("phone")?.let {
            phone = it
        }
        if (currentId != -1) {
            viewModelScope.launch {
                useCase.getPersonWithDress(phone).onEach { personDress ->
                    personDress.forEach { personWithDress ->
                        personWithDress.dresses.forEach {
                            currentId = it.id
                            if (it.id == currentId) {
                                _name.value = name.value.copy(
                                    text = it.name,
                                    isHintVisible = false
                                )
                                _price.value = price.value.copy(
                                    text = it.price.toString(),
                                    isHintVisible = false
                                )
                                _paid.value = paid.value.copy(
                                    text = it.paid.toString(),
                                    isHintVisible = false
                                )
                                _accountBalance.value = accountBalance.value.copy(
                                    text = it.account_balance.toString(),
                                    isHintVisible = false
                                )
                                _startDate.value = startDate.value.copy(
                                    text = it.start_date.toString(),
                                    isHintVisible = false
                                )
                                _deliveryDate.value = deliveryDate.value.copy(
                                    text = it.delivery_date.toString(),
                                    isHintVisible = false
                                )
                                phone = it.phone

                            }

                        }
                    }
                }
            }
        }
    }

    fun onEvent(event: AddDressEvent) {

        when (event) {
            is AddDressEvent.EnteredName -> {
                _name.value = name.value.copy(
                    text = event.value
                )
            }
            is AddDressEvent.ChangeFocusName -> {
                _name.value = name.value.copy(
                    isHintVisible = !event.focusState.isFocused && name.value.text.isBlank()
                )
            }
            is AddDressEvent.EnteredPrice -> {
                _price.value = price.value.copy(
                    text = event.value
                )
            }
            is AddDressEvent.ChangeFocusPrice -> {
                _price.value = price.value.copy(
                    isHintVisible = !event.focusState.isFocused && price.value.text.isBlank()
                )
            }
            is AddDressEvent.EnteredPaid -> {
                _paid.value = paid.value.copy(
                    text = event.value
                )
            }
            is AddDressEvent.ChangeFocusPaid -> {
                _paid.value = paid.value.copy(
                    isHintVisible = !event.focusState.isFocused && paid.value.text.isBlank()
                )
            }
            is AddDressEvent.EnteredAccountBalance -> {
                _accountBalance.value = accountBalance.value.copy(
                    text = event.value
                )
            }
            is AddDressEvent.ChangeFocusAccountBalance -> {
                _accountBalance.value = accountBalance.value.copy(
                    isHintVisible = !event.focusState.isFocused && accountBalance.value.text.isBlank()
                )
            }
            is AddDressEvent.EnteredStartDate -> {
                _startDate.value = startDate.value.copy(
                    text = event.value
                )
            }
            is AddDressEvent.ChangeFocusStartDate -> {
                _startDate.value = startDate.value.copy(
                    isHintVisible = !event.focusState.isFocused && startDate.value.text.isBlank()
                )
            }
            is AddDressEvent.EnteredDeliveryDate -> {
                _deliveryDate.value = deliveryDate.value.copy(
                    text = event.value
                )
            }
            is AddDressEvent.ChangeFocusDeliveryDate -> {
                _deliveryDate.value = deliveryDate.value.copy(
                    isHintVisible = !event.focusState.isFocused && deliveryDate.value.text.isBlank()
                )
            }
            is AddDressEvent.saveDress -> {
                saveDress()
            }
        }
    }

    private fun saveDress() {
        val inputName = validateInput.execute(name.value.text)
        val inputPrice = validateNumber.execute(price.value.text)
        val inputPaid = validateNumber.execute(paid.value.text)
        val inputStartDate = validateInput.execute(startDate.value.text)
        val inputDeliveryDate = validateInput.execute(deliveryDate.value.text)

        val hasError = listOf(
            inputName,
            inputPrice,
            inputPaid,
            inputStartDate,
            inputDeliveryDate
        ).any { !it.successful }
        if (hasError) {
            _name.value = name.value.copy(
                errorMessage = inputName.errorMessage,
                isError = true,
                isHintVisible = false
            )
            _price.value = price.value.copy(
                errorMessage = inputPrice.errorMessage,
                isError = true,
                isHintVisible = false

            )
            _paid.value = paid.value.copy(
                errorMessage = inputPaid.errorMessage,
                isError = true,
                isHintVisible = false
            )
            _startDate.value = startDate.value.copy(
                errorMessage = inputStartDate.errorMessage,
                isError = true,
                isHintVisible = false
            )
            _deliveryDate.value = deliveryDate.value.copy(
                errorMessage = inputDeliveryDate.errorMessage,
                isError = true,
                isHintVisible = false
            )
            return
        }
        _name.value = name.value.copy(
            errorMessage = null,
            isError = false,
            isHintVisible = true
        )
        _price.value = price.value.copy(
            errorMessage = null,
            isError = false,
            isHintVisible = true
        )
        _paid.value = paid.value.copy(
            errorMessage = null,
            isError = false,
            isHintVisible = true
        )
        _accountBalance.value = accountBalance.value.copy(
            errorMessage = null,
            isError = false,
            isHintVisible = true
        )
        _startDate.value = startDate.value.copy(
            errorMessage = null,
            isError = false,
            isHintVisible = true
        )
        _deliveryDate.value = deliveryDate.value.copy(
            errorMessage = null,
            isError = false,
            isHintVisible = true
        )
        viewModelScope.launch {
            try {
                val accountBalance = price.value.text.toLong() - paid.value.text.toLong()
                useCase.addDress(
                    Dress(
                        id = currentId,
                        name = name.value.text,
                        phone = phone,
                        price = price.value.text.toLong(),
                        paid = paid.value.text.toLong(),
                        account_balance = accountBalance,
                        start_date = startDate.value.text,
                        delivery_date = deliveryDate.value.text,
                        not_paid = accountBalance > 0
                    )
                )
                _eventSharedFlow.emit(UiEvent.SaveDress)
            } catch (e: Exception) {
                _eventSharedFlow.emit(UiEvent.ShowSnackBar(
                    message = e.message ?: "save nashod lebas"
                ))
            }

        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        object SaveDress : UiEvent()
    }
}