package com.example.tailormeasure.presentation.person.add_eddit_person

import androidx.compose.ui.focus.FocusState

sealed class AddEditPersonEvent {
    data class EnteredName(val value :String) : AddEditPersonEvent()
    data class ChangeNameFocus(val focusState: FocusState) : AddEditPersonEvent()
    data class EnteredFamily(val value :String) : AddEditPersonEvent()
    data class ChangeFamilyFocus(val focusState: FocusState) : AddEditPersonEvent()
    data class EnteredPhone(val value :String) : AddEditPersonEvent()
    data class ChangePhoneFocus(val focusState: FocusState) : AddEditPersonEvent()
    object SavePerson : AddEditPersonEvent()
}