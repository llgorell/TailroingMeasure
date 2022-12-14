package com.example.tailormeasure.presentation.size_body

import androidx.compose.ui.focus.FocusState

sealed class OnAddSizeEvent {
    data class EntereddorGardan(val value : String) : OnAddSizeEvent()
    data class ChangeFocudorGardan(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredsarShane(val value : String) : OnAddSizeEvent()
    data class ChangeFocussarShane(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredkarorJolo(val value : String) : OnAddSizeEvent()
    data class ChangeFocuskarorJolo(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredkarorPosht(val value : String) : OnAddSizeEvent()
    data class ChangeFocuskarorPosht(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredghadBalaTaneJolo(val value : String) : OnAddSizeEvent()
    data class ChangeFocusghadBalaTaneJolo(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredghadBalaTanePost(val value : String) : OnAddSizeEvent()
    data class ChangeFocusghadBalaTanePost(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredghadSine(val value : String) : OnAddSizeEvent()
    data class ChangeFocusghadSine(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredfaseleSine(val value : String) : OnAddSizeEvent()
    data class ChangeFocusfaseleSine(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorSine(val value : String) : OnAddSizeEvent()
    data class ChangeFocusdorSine(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorKamar(val value : String) : OnAddSizeEvent()
    data class ChangeFocusdorKamar(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorBasan(val value : String) : OnAddSizeEvent()
    data class ChangeFocusdorBasan(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorBazo(val value : String) : OnAddSizeEvent()
    data class ChangeFocusdorBazo(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorMoch(val value : String) : OnAddSizeEvent()
    data class ChangeFocusdorMoch(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredghadAstin(val value : String) : OnAddSizeEvent()
    data class ChangeFocusghadAstin(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredghadLebas(val value : String) : OnAddSizeEvent()
    data class ChangeFocusghadLebas(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredbazieYaghe(val value : String) : OnAddSizeEvent()
    data class ChangebazieYaghe(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredghadBasan(val value : String) : OnAddSizeEvent()
    data class ChangeFocusghadBasan(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorHalgheAstin(val value : String) : OnAddSizeEvent()
    data class ChangeFocusdorHalgheAstin(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorRan(val value : String) : OnAddSizeEvent()
    data class ChangeFocusdorRan(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorZano(val  value : String) : OnAddSizeEvent()
    data class ChangeFocusdorZano(val focusState: FocusState) : OnAddSizeEvent()

    data class EntereddorDamPa(val value : String) : OnAddSizeEvent()
    data class ChangeFocusdorDamPa(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredghadShalvar(val value : String) : OnAddSizeEvent()
    data class ChangeFocusghadShalvar(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredghadZano(val value : String) : OnAddSizeEvent()
    data class ChangeFocusghadZano(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredanforShor(val value : String) : OnAddSizeEvent()
    data class ChangeFocusanforShor(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredantiJanp(val value : String) : OnAddSizeEvent()
    data class ChangeFocusantiJanp(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredbaramadegieBasan(val value : String) : OnAddSizeEvent()
    data class ChangeFocusbaramadegieBasan(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredWeight(val value : String) : OnAddSizeEvent()
    data class ChangeFocusWeight(val focusState: FocusState) : OnAddSizeEvent()

    data class EnteredGhad(val value : String) : OnAddSizeEvent()
    data class ChangeFocusGhad(val focusState: FocusState) : OnAddSizeEvent()

    object SaveSize : OnAddSizeEvent()
}
