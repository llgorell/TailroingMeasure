package com.example.tailormeasure.presentation.dress

import androidx.compose.ui.focus.FocusState

sealed class AddDressEvent{

    data class EnteredName(val value : String) : AddDressEvent()
    data class ChangeFocusName(val focusState: FocusState ) : AddDressEvent()

    data class EnteredPrice(val value : String) : AddDressEvent()
    data class ChangeFocusPrice(val focusState: FocusState ) : AddDressEvent()

    data class EnteredPaid(val value : String) : AddDressEvent()
    data class ChangeFocusPaid(val focusState: FocusState ) : AddDressEvent()

    data class EnteredAccountBalance(val value : String) : AddDressEvent()
    data class ChangeFocusAccountBalance(val focusState: FocusState ) : AddDressEvent()

    data class EnteredStartDate(val value : String) : AddDressEvent()
    data class ChangeFocusStartDate(val focusState: FocusState ) : AddDressEvent()

    data class EnteredDeliveryDate(val value : String) : AddDressEvent()
    data class ChangeFocusDeliveryDate(val focusState: FocusState ) : AddDressEvent()

    object saveDress : AddDressEvent()
}
