package com.example.tailormeasure.presentation.size_body

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tailormeasure.domain.model.SizeBody
import com.example.tailormeasure.domain.use_case.PersonUseCase
import com.example.tailormeasure.domain.use_case.util.ValidateNumber
import com.example.tailormeasure.presentation.person.add_eddit_person.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditSizeViewModel @Inject constructor(
    private val useCase: PersonUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val validateNumber: ValidateNumber,
) : ViewModel() {

    private var phone: String = ""
    private var name: String = ""

    private val _eventSharedFlow = MutableSharedFlow<UiEvent>()
    val sharedFlow = _eventSharedFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>("phone")?.let {
                useCase.getPerson(it)?.let { person ->
                    phone = person.phone
                    name = person.name
                }
            }
        }
    }

    private val _dorGardan = mutableStateOf(TextFieldState(
        hint = "دور گردن"
    ))
    val dorGardan: State<TextFieldState> = _dorGardan

    private val _sarShane = mutableStateOf(TextFieldState(
        hint = "سرشانه"
    ))
    val sarShane: State<TextFieldState> = _sarShane

    private val _karorJolo = mutableStateOf(TextFieldState(
        hint = "کارور جلو"
    ))
    val karorJolo: State<TextFieldState> = _karorJolo

    private val _karorPosht = mutableStateOf(TextFieldState(
        hint = "کارور پشت"
    ))
    val karorPosht: State<TextFieldState> = _karorPosht

    private val _ghadBalaTaneJolo = mutableStateOf(TextFieldState(
        hint = "قدبالاتنه جلو"
    ))
    val ghadBalaTaneJolo: State<TextFieldState> = _ghadBalaTaneJolo

    private val _ghadBalaTanePost = mutableStateOf(TextFieldState(
        hint = " قدبالاتنه پشت"
    ))
    val ghadBalaTanePost: State<TextFieldState> = _ghadBalaTanePost

    private val _ghadSine = mutableStateOf(TextFieldState(
        hint = "قدسینه"
    ))
    val ghadSine: State<TextFieldState> = _ghadSine

    private val _faseleSine = mutableStateOf(TextFieldState(
        hint = "فاصله سینه"
    ))
    val faseleSine: State<TextFieldState> = _faseleSine

    private val _dorSine = mutableStateOf(TextFieldState(
        hint = "دور سینه"
    ))
    val dorSine: State<TextFieldState> = _dorSine

    private val _dorKamar = mutableStateOf(TextFieldState(
        hint = "دور کمر"
    ))
    val dorKamar: State<TextFieldState> = _dorKamar

    private val _dorBasan = mutableStateOf(TextFieldState(
        hint = "دور باسن"
    ))
    val dorBasan: State<TextFieldState> = _dorBasan

    private val _dorBazo = mutableStateOf(TextFieldState(
        hint = "دور بازو"
    ))
    val dorBazo: State<TextFieldState> = _dorBazo

    private val _dorMoch = mutableStateOf(TextFieldState(
        hint = "دور مچ"
    ))
    val dorMoch: State<TextFieldState> = _dorMoch

    private val _ghadAstin = mutableStateOf(TextFieldState(
        hint = "قدآستین"
    ))
    val ghadAstin: State<TextFieldState> = _ghadAstin

    private val _ghadLebas = mutableStateOf(TextFieldState(
        hint = "قد لباس"
    ))
    val ghadLebas: State<TextFieldState> = _ghadLebas

    private val _bazieYaghe = mutableStateOf(TextFieldState(
        hint = "بازی یقه"
    ))
    val bazieYaghe: State<TextFieldState> = _bazieYaghe

    private val _ghadBasan = mutableStateOf(TextFieldState(
        hint = "قد باسن"
    ))
    val ghadBasan: State<TextFieldState> = _ghadBasan

    private val _dorHalgheAstin = mutableStateOf(TextFieldState(
        hint = "دور حلقه آستین"
    ))
    val dorHalgheAstin: State<TextFieldState> = _dorHalgheAstin

    private val _dorRan = mutableStateOf(TextFieldState(
        hint = "دور ران"
    ))
    val dorRan: State<TextFieldState> = _dorRan

    private val _dorZano = mutableStateOf(TextFieldState(
        hint = "دور زانو"
    ))
    val dorZano: State<TextFieldState> = _dorZano

    private val _dorDamPa = mutableStateOf(TextFieldState(
        hint = "دور دم پا"
    ))
    val dorDamPa: State<TextFieldState> = _dorDamPa

    private val _ghadShalvar = mutableStateOf(TextFieldState(
        hint = "قد شلوار"
    ))
    val ghadShalvar: State<TextFieldState> = _ghadShalvar

    private val _ghadZano = mutableStateOf(TextFieldState(
        hint = "قد زانو"
    ))
    val ghadZano: State<TextFieldState> = _ghadZano

    private val _anforShor = mutableStateOf(TextFieldState(
        hint = "آنفورشور"
    ))
    val anforShor: State<TextFieldState> = _anforShor

    private val _antiJanp = mutableStateOf(TextFieldState(
        hint = "آنتی ژانپ"
    ))
    val antiJanp: State<TextFieldState> = _antiJanp

    private val _baramadegieBasan = mutableStateOf(TextFieldState(
        hint = "برآمدگی باسن"
    ))
    val baramadegieBasan: State<TextFieldState> = _baramadegieBasan

    private val _weight = mutableStateOf(TextFieldState(
        hint = "وزن"
    ))
    val weight: State<TextFieldState> = _weight

    private val _ghad = mutableStateOf(TextFieldState(
        hint = "قد"
    ))
    val ghad: State<TextFieldState> = _ghad

    fun onEvent(event: OnAddSizeEvent) {
        when (event) {
            is OnAddSizeEvent.EntereddorGardan -> {
                _dorGardan.value = dorGardan.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocudorGardan -> {
                _dorGardan.value = dorGardan.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorGardan.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredsarShane -> {
                _sarShane.value = sarShane.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocussarShane -> {
                _sarShane.value = sarShane.value.copy(
                    isHintVisible = !event.focusState.isFocused && sarShane.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredkarorJolo -> {
                _karorJolo.value = karorJolo.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocuskarorJolo -> {
                _karorJolo.value = karorJolo.value.copy(
                    isHintVisible = !event.focusState.isFocused && karorJolo.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredkarorPosht -> {
                _karorPosht.value = karorPosht.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocuskarorPosht -> {
                _karorPosht.value = karorPosht.value.copy(
                    isHintVisible = !event.focusState.isFocused && karorPosht.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredghadBalaTaneJolo -> {
                _ghadBalaTaneJolo.value = ghadBalaTaneJolo.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusghadBalaTaneJolo -> {
                _ghadBalaTaneJolo.value = ghadBalaTaneJolo.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghadBalaTaneJolo.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredghadBalaTanePost -> {
                _ghadBalaTanePost.value = ghadBalaTanePost.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusghadBalaTanePost -> {
                _ghadBalaTanePost.value = ghadBalaTanePost.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghadBalaTanePost.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredghadSine -> {
                _ghadSine.value = ghadSine.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusghadSine -> {
                _ghadSine.value = ghadSine.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghadSine.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredfaseleSine -> {
                _faseleSine.value = faseleSine.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusfaseleSine -> {
                _faseleSine.value = faseleSine.value.copy(
                    isHintVisible = !event.focusState.isFocused && faseleSine.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorSine -> {
                _dorSine.value = dorSine.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorSine -> {
                _dorSine.value = dorSine.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorSine.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorKamar -> {
                _dorKamar.value = dorKamar.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorKamar -> {
                _dorKamar.value = dorKamar.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorKamar.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorBasan -> {
                _dorBasan.value = dorBasan.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorBasan -> {
                _dorBasan.value = dorBasan.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorBasan.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorBazo -> {
                _dorBazo.value = dorBazo.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorBazo -> {
                _dorBazo.value = dorBazo.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorBazo.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorMoch -> {
                _dorMoch.value = dorMoch.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorMoch -> {
                _dorMoch.value = dorMoch.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorMoch.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredghadAstin -> {
                _ghadAstin.value = ghadAstin.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusghadAstin -> {
                _ghadAstin.value = ghadAstin.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghadSine.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredghadLebas -> {
                _ghadLebas.value = ghadLebas.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusghadLebas -> {
                _ghadLebas.value = ghadLebas.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghadLebas.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredbazieYaghe -> {
                _bazieYaghe.value = bazieYaghe.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangebazieYaghe -> {
                _bazieYaghe.value = bazieYaghe.value.copy(
                    isHintVisible = !event.focusState.isFocused && bazieYaghe.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredghadBasan -> {
                _ghadBasan.value = ghadBasan.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusghadBasan -> {
                _ghadBasan.value = ghadBasan.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghadBasan.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorHalgheAstin -> {
                _dorHalgheAstin.value = dorHalgheAstin.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorHalgheAstin -> {
                _dorHalgheAstin.value = dorHalgheAstin.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorHalgheAstin.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorRan -> {
                _dorRan.value = dorRan.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorRan -> {
                _dorRan.value = dorRan.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorRan.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorZano -> {
                _dorZano.value = dorZano.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorZano -> {
                _dorZano.value = dorZano.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorZano.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EntereddorDamPa -> {
                _dorDamPa.value = dorDamPa.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusdorDamPa -> {
                _dorDamPa.value = dorDamPa.value.copy(
                    isHintVisible = !event.focusState.isFocused && dorDamPa.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredghadShalvar -> {
                _ghadShalvar.value = ghadShalvar.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusghadShalvar -> {
                _ghadShalvar.value = ghadShalvar.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghadShalvar.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredghadZano -> {
                _ghadZano.value = ghadZano.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusghadZano -> {
                _ghadZano.value = ghadZano.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghadZano.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredanforShor -> {
                _anforShor.value = anforShor.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusanforShor -> {
                _anforShor.value = anforShor.value.copy(
                    isHintVisible = !event.focusState.isFocused && anforShor.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredantiJanp -> {
                _antiJanp.value = antiJanp.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusantiJanp -> {
                _antiJanp.value = antiJanp.value.copy(
                    isHintVisible = !event.focusState.isFocused && antiJanp.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredbaramadegieBasan -> {
                _baramadegieBasan.value = baramadegieBasan.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusbaramadegieBasan -> {
                _baramadegieBasan.value = baramadegieBasan.value.copy(
                    isHintVisible = !event.focusState.isFocused && baramadegieBasan.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredWeight -> {
                _weight.value = weight.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusWeight -> {
                _weight.value = weight.value.copy(
                    isHintVisible = !event.focusState.isFocused && weight.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.EnteredGhad -> {
                _ghad.value = ghad.value.copy(
                    text = event.value
                )
            }
            is OnAddSizeEvent.ChangeFocusGhad -> {
                _ghad.value = ghad.value.copy(
                    isHintVisible = !event.focusState.isFocused && ghad.value.text.isBlank()
                )
            }
            is OnAddSizeEvent.SaveSize -> {
                saveSize()
            }
        }
    }

    private fun saveSize() {
        val resultDorGardan = validateNumber.execute(dorGardan.value.text)
        val resultsarShane = validateNumber.execute(sarShane.value.text)
        val resultkarorJolo = validateNumber.execute(karorJolo.value.text)
        val resultkarorPosht = validateNumber.execute(karorPosht.value.text)
        val resultghadBalaTaneJolo = validateNumber.execute(ghadBalaTaneJolo.value.text)
        val resultghadBalaTanePost = validateNumber.execute(ghadBalaTanePost.value.text)
        val resultghadSine = validateNumber.execute(ghadSine.value.text)
        val resultfaseleSine = validateNumber.execute(faseleSine.value.text)
        val resultdorSine = validateNumber.execute(dorSine.value.text)
        val resultdorKamar = validateNumber.execute(dorKamar.value.text)
        val resultdorBasan = validateNumber.execute(dorBasan.value.text)
        val resultdorBazo = validateNumber.execute(dorBazo.value.text)
        val resultdorMoch = validateNumber.execute(dorMoch.value.text)
        val resultghadAstin = validateNumber.execute(ghadAstin.value.text)
        val resultghadLebas = validateNumber.execute(ghadLebas.value.text)
        val resultbazieYaghe = validateNumber.execute(bazieYaghe.value.text)
        val resultghadBasan = validateNumber.execute(ghadBasan.value.text)
        val resultdorHalgheAstin = validateNumber.execute(dorHalgheAstin.value.text)
        val resultdorRan = validateNumber.execute(dorRan.value.text)
        val resultdorZano = validateNumber.execute(dorZano.value.text)
        val resultdorDamPa = validateNumber.execute(dorDamPa.value.text)
        val resultghadShalvar = validateNumber.execute(ghadShalvar.value.text)
        val resultghadZano = validateNumber.execute(ghadZano.value.text)
        val resultanforShor = validateNumber.execute(anforShor.value.text)
        val resultantiJanp = validateNumber.execute(antiJanp.value.text)
        val resultbaramadegieBasan = validateNumber.execute(baramadegieBasan.value.text)
        val resultWeight = validateNumber.execute(weight.value.text)
        val resultGhad = validateNumber.execute(ghad.value.text)

        val hasError = listOf(
            resultDorGardan,
            resultsarShane,
            resultkarorJolo,
            resultkarorPosht,
            resultghadBalaTaneJolo,
            resultghadBalaTanePost,
            resultghadSine,
            resultfaseleSine,
            resultdorSine,
            resultdorKamar,
            resultdorBasan,
            resultdorBazo,
            resultdorMoch,
            resultghadAstin,
            resultghadLebas,
            resultbazieYaghe,
            resultghadBasan,
            resultdorHalgheAstin,
            resultdorRan,
            resultdorZano,
            resultdorDamPa,
            resultghadShalvar,
            resultghadZano,
            resultanforShor,
            resultantiJanp,
            resultbaramadegieBasan,
            resultWeight,
            resultGhad
        ).any { !it.successful }

        if (hasError) {
            _dorGardan.value = dorGardan.value.copy(
                errorMessage = resultDorGardan.errorMessage,
                isHintVisible = resultDorGardan.successful,
                isError = !resultDorGardan.successful
            )
            _sarShane.value = sarShane.value.copy(
                errorMessage = resultsarShane.errorMessage,
                isHintVisible = resultsarShane.successful,
                isError = !resultsarShane.successful
            )
            _karorJolo.value = karorJolo.value.copy(
                errorMessage = resultkarorJolo.errorMessage,
                isHintVisible = resultkarorJolo.successful,
                isError = !resultkarorJolo.successful
            )
            _karorPosht.value = karorPosht.value.copy(
                errorMessage = resultkarorPosht.errorMessage,
                isHintVisible = resultkarorPosht.successful,
                isError = !resultkarorPosht.successful
            )
            _ghadBalaTaneJolo.value = ghadBalaTaneJolo.value.copy(
                errorMessage = resultghadBalaTaneJolo.errorMessage,
                isHintVisible = resultghadBalaTaneJolo.successful,
                isError = !resultghadBalaTaneJolo.successful
            )
            _ghadBalaTanePost.value = ghadBalaTanePost.value.copy(
                errorMessage = resultghadBalaTanePost.errorMessage,
                isHintVisible = resultghadBalaTanePost.successful,
                isError = !resultghadBalaTanePost.successful
            )
            _ghadSine.value = ghadSine.value.copy(
                errorMessage = resultghadSine.errorMessage,
                isHintVisible = resultghadSine.successful,
                isError = !resultghadSine.successful
            )
            _faseleSine.value = faseleSine.value.copy(
                errorMessage = resultfaseleSine.errorMessage,
                isHintVisible = resultfaseleSine.successful,
                isError = !resultfaseleSine.successful
            )
            _dorSine.value = dorSine.value.copy(
                errorMessage = resultdorSine.errorMessage,
                isHintVisible = resultdorSine.successful,
                isError = !resultdorSine.successful
            )
            _dorKamar.value = dorKamar.value.copy(
                errorMessage = resultdorKamar.errorMessage,
                isHintVisible = resultdorKamar.successful,
                isError = resultdorKamar.successful
            )
            _dorBasan.value = dorBasan.value.copy(
                errorMessage = resultdorBasan.errorMessage,
                isHintVisible = resultdorBasan.successful,
                isError = !resultdorBasan.successful
            )
            _dorBazo.value = dorBazo.value.copy(
                errorMessage = resultdorBazo.errorMessage,
                isHintVisible = resultdorBazo.successful,
                isError = !resultdorBazo.successful
            )
            _dorMoch.value = dorMoch.value.copy(
                errorMessage = resultdorMoch.errorMessage,
                isHintVisible = resultdorMoch.successful,
                isError = !resultdorMoch.successful
            )
            _ghadAstin.value = ghadAstin.value.copy(
                errorMessage = resultghadAstin.errorMessage,
                isHintVisible = resultghadAstin.successful,
                isError = !resultghadAstin.successful
            )
            _ghadLebas.value = ghadLebas.value.copy(
                errorMessage = resultghadLebas.errorMessage,
                isHintVisible = resultghadLebas.successful,
                isError = !resultghadLebas.successful
            )
            _bazieYaghe.value = bazieYaghe.value.copy(
                errorMessage = resultbazieYaghe.errorMessage,
                isHintVisible = resultbazieYaghe.successful,
                isError = !resultbazieYaghe.successful
            )
            _ghadBasan.value = ghadBasan.value.copy(
                errorMessage = resultghadBasan.errorMessage,
                isHintVisible = resultghadBasan.successful,
                isError = !resultghadBasan.successful
            )
            _dorHalgheAstin.value = dorHalgheAstin.value.copy(
                errorMessage = resultdorHalgheAstin.errorMessage,
                isHintVisible = resultdorHalgheAstin.successful,
                isError = !resultdorHalgheAstin.successful
            )
            _dorRan.value = dorRan.value.copy(
                errorMessage = resultdorRan.errorMessage,
                isHintVisible = resultdorRan.successful,
                isError = resultdorRan.successful
            )
            _dorZano.value = dorZano.value.copy(
                errorMessage = resultdorZano.errorMessage,
                isHintVisible = resultdorZano.successful,
                isError = !resultdorZano.successful
            )
            _dorDamPa.value = dorDamPa.value.copy(
                errorMessage = resultdorDamPa.errorMessage,
                isHintVisible = resultdorDamPa.successful,
                isError = !resultdorDamPa.successful
            )
            _ghadShalvar.value = ghadShalvar.value.copy(
                errorMessage = resultghadShalvar.errorMessage,
                isHintVisible = resultghadShalvar.successful,
                isError = !resultghadShalvar.successful
            )
            _ghadZano.value = ghadZano.value.copy(
                errorMessage = resultghadZano.errorMessage,
                isHintVisible = resultghadZano.successful,
                isError = !resultghadZano.successful
            )
            _anforShor.value = anforShor.value.copy(
                errorMessage = resultanforShor.errorMessage,
                isHintVisible = resultanforShor.successful,
                isError = !resultanforShor.successful
            )
            _antiJanp.value = antiJanp.value.copy(
                errorMessage = resultantiJanp.errorMessage,
                isHintVisible = resultantiJanp.successful,
                isError = !resultantiJanp.successful
            )
            _baramadegieBasan.value = baramadegieBasan.value.copy(
                errorMessage = resultbaramadegieBasan.errorMessage,
                isHintVisible = resultbaramadegieBasan.successful,
                isError = !resultbaramadegieBasan.successful
            )
            _weight.value = weight.value.copy(
                errorMessage = resultWeight.errorMessage,
                isHintVisible = resultWeight.successful,
                isError = !resultWeight.successful
            )
            _ghad.value = ghad.value.copy(
                errorMessage = resultGhad.errorMessage,
                isHintVisible = resultGhad.successful,
                isError = !resultGhad.successful
            )
            return
        }
        viewModelScope.launch {
            try {
                useCase.addSize(
                    SizeBody(
                        name_of_body = name,
                        phone = phone,
                        dor_gardan = dorGardan.value.text.toFloat(),
                        sar_shane = sarShane.value.text.toFloat(),
                        karor_jolo = karorJolo.value.text.toFloat(),
                        karor_posht = karorPosht.value.text.toFloat(),
                        ghad_balatane_jolo = ghadBalaTaneJolo.value.text.toFloat(),
                        ghad_balatane_posht = ghadBalaTanePost.value.text.toFloat(),
                        ghad_astin = ghadAstin.value.text.toFloat(),
                        ghad_sine = ghadSine.value.text.toFloat(),
                        fasele_sine = faseleSine.value.text.toFloat(),
                        dor_sine = dorSine.value.text.toFloat(),
                        dor_kamar = dorKamar.value.text.toFloat(),
                        dor_basan = dorBasan.value.text.toFloat(),
                        dor_bazo = dorBazo.value.text.toFloat(),
                        dor_moch = dorMoch.value.text.toFloat(),
                        ghad_lebas = ghadLebas.value.text.toFloat(),
                        bazie_yaghe = bazieYaghe.value.text.toFloat(),
                        ghad_basan = ghadBasan.value.text.toFloat(),
                        dor_halghe_astin = dorHalgheAstin.value.text.toFloat(),
                        dor_ran = dorRan.value.text.toFloat(),
                        dor_zano = dorZano.value.text.toFloat(),
                        dor_damPa = dorDamPa.value.text.toFloat(),
                        ghad_shalvar = ghadShalvar.value.text.toFloat(),
                        ghad_zano = ghadZano.value.text.toFloat(),
                        anforShor = anforShor.value.text.toFloat(),
                        antijanp = antiJanp.value.text.toFloat(),
                        baramadegie_basan = baramadegieBasan.value.text.toFloat(),
                        weight = weight.value.text.toFloat(),
                        ghad = ghad.value.text.toFloat()
                    )
                )
                _eventSharedFlow.emit(UiEvent.SaveSize)

            }catch (e:Exception){
                _eventSharedFlow.emit(UiEvent.ShowSnackBar(
                    message = e.message ?: "سابز ذخیره نشد"
                ))
            }

        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        object SaveSize : UiEvent()
    }
}

