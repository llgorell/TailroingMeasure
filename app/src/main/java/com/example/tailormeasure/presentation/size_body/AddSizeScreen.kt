package com.example.tailormeasure.presentation.size_body

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tailormeasure.R
import com.example.tailormeasure.presentation.util.InputTextField

@Composable
fun AddSizeScreen(
    navController: NavController,
    viewmodel: AddEditSizeViewModel = hiltViewModel(),
) {

    val scaffoldState = rememberScaffoldState()

    val dorGardan = viewmodel.dorGardan.value
    val sarShane = viewmodel.sarShane.value
    val karorJolo = viewmodel.karorJolo.value
    val karorPosht = viewmodel.karorPosht.value
    val ghadBalaTaneJolo = viewmodel.ghadBalaTaneJolo.value
    val ghadBalaTanePost = viewmodel.ghadBalaTanePost.value
    val ghadSine = viewmodel.ghadSine.value
    val faseleSine = viewmodel.faseleSine.value
    val dorSine = viewmodel.dorSine.value
    val dorKamar = viewmodel.dorKamar.value
    val dorBasan = viewmodel.dorBasan.value
    val dorBazo = viewmodel.dorBazo.value
    val dorMoch = viewmodel.dorMoch.value
    val ghadAstin = viewmodel.ghadAstin.value
    val ghadLebas = viewmodel.ghadLebas.value
    val bazieYaghe = viewmodel.bazieYaghe.value
    val ghadBasan = viewmodel.ghadBasan.value
    val dorHalgheAstin = viewmodel.dorHalgheAstin.value
    val dorRan = viewmodel.dorRan.value
    val dorZano = viewmodel.dorZano.value
    val dorDamPa = viewmodel.dorDamPa.value
    val ghadShalvar = viewmodel.ghadShalvar.value
    val ghadZano = viewmodel.ghadZano.value
    val anforShor = viewmodel.anforShor.value
    val antiJanp = viewmodel.antiJanp.value
    val baramadegieBasan = viewmodel.baramadegieBasan.value
    val weight = viewmodel.weight.value
    val ghad = viewmodel.ghad.value

    LaunchedEffect(key1 = true) {
        viewmodel.sharedFlow.collect() { event ->
            when (event) {
                is AddEditSizeViewModel.UiEvent.SaveSize -> {
                    navController.navigateUp()
                }
                is AddEditSizeViewModel.UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message
                    )
                }
            }
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = { padding ->

            Column(Modifier.padding(padding)) {
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = dorGardan.text,
                        hint = dorGardan.hint,
                        errorMessage = dorGardan.errorMessage ?: "",
                        isVisibleHint = dorGardan.isHintVisible,
                        singleLine = true,
                        isError = dorGardan.isError,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorGardan(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocudorGardan(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = sarShane.text,
                        hint = sarShane.hint,
                        singleLine = true,
                        isError = sarShane.isError,
                        isVisibleHint = sarShane.isHintVisible,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        errorMessage = sarShane.errorMessage ?: "",
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredsarShane(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocussarShane(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = karorJolo.text,
                        hint = karorJolo.hint,
                        singleLine = true,
                        isVisibleHint = karorJolo.isHintVisible,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        errorMessage = karorJolo.errorMessage ?: "",
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredkarorJolo(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocuskarorJolo(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = karorPosht.text,
                        hint = karorPosht.hint,
                        errorMessage = karorPosht.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredkarorPosht(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocuskarorPosht(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = ghadBalaTaneJolo.text,
                        hint = ghadBalaTaneJolo.hint,
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        errorMessage = ghadBalaTaneJolo.errorMessage ?: "",
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredghadBalaTaneJolo(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusghadBalaTaneJolo(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = ghadBalaTanePost.text,
                        hint = ghadBalaTanePost.hint,
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        errorMessage = ghadBalaTanePost.errorMessage ?: "",
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredghadBalaTanePost(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusghadBalaTanePost(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = ghadSine.text,
                        hint = ghadSine.hint,
                        errorMessage = ghadSine.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredghadSine(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusghadSine(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = faseleSine.text,
                        hint = faseleSine.hint,
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        errorMessage = faseleSine.errorMessage ?: "",
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredfaseleSine(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusfaseleSine(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = dorSine.text,
                        hint = dorSine.hint,
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        errorMessage = dorSine.errorMessage ?: "",
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorSine(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorSine(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = dorKamar.text,
                        hint = dorKamar.hint,
                        errorMessage = dorKamar.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorKamar(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorKamar(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = dorBasan.text,
                        hint = dorBasan.hint,
                        errorMessage = dorBasan.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorBasan(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorBasan(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = dorBazo.text,
                        hint = dorBazo.hint,
                        errorMessage = dorBazo.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorBazo(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorBazo(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = dorMoch.text,
                        hint = dorMoch.hint,
                        errorMessage = dorMoch.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorMoch(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorMoch(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = ghadAstin.text,
                        hint = ghadAstin.hint,
                        errorMessage = ghadAstin.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredghadAstin(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusghadAstin(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = ghadLebas.text,
                        hint = ghadLebas.hint,
                        errorMessage = ghadLebas.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredghadLebas(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusghadLebas(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = bazieYaghe.text,
                        hint = bazieYaghe.hint,
                        errorMessage = bazieYaghe.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredbazieYaghe(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangebazieYaghe(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = ghadBasan.text,
                        hint = ghadBasan.hint,
                        errorMessage = ghadBasan.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredghadBasan(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusghadBasan(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = dorHalgheAstin.text,
                        hint = dorHalgheAstin.hint,
                        errorMessage = dorHalgheAstin.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorHalgheAstin(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorHalgheAstin(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = dorRan.text,
                        hint = dorRan.hint,
                        errorMessage = dorRan.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorRan(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorRan(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = dorZano.text,
                        hint = dorZano.hint,
                        errorMessage = dorZano.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorZano(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorZano(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = dorDamPa.text,
                        hint = dorDamPa.hint,
                        errorMessage = dorDamPa.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EntereddorDamPa(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusdorDamPa(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = ghadShalvar.text,
                        hint = ghadShalvar.hint,
                        errorMessage = ghadShalvar.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredghadShalvar(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusghadShalvar(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = ghadZano.text,
                        hint = ghadZano.hint,
                        errorMessage = ghadZano.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredghadZano(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusghadZano(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = baramadegieBasan.text,
                        hint = baramadegieBasan.hint,
                        errorMessage = baramadegieBasan.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredbaramadegieBasan(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusbaramadegieBasan(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    InputTextField(text = anforShor.text,
                        hint = anforShor.hint,
                        errorMessage = anforShor.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredanforShor(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusanforShor(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = antiJanp.text,
                        hint = antiJanp.hint,
                        errorMessage = antiJanp.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredantiJanp(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusantiJanp(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    InputTextField(text = weight.text,
                        hint = weight.hint,
                        errorMessage = weight.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredWeight(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusWeight(it)) },
                        modifier = Modifier.weight(1f)
                    )

                }
                Row(modifier = Modifier
                    .weight(3f)
                    .padding(horizontal = 8.dp)) {
                    InputTextField(text = ghad.text,
                        hint = ghad.hint,
                        errorMessage = ghad.errorMessage ?: "",
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        onChangeValue = { viewmodel.onEvent(OnAddSizeEvent.EnteredGhad(it)) },
                        onFocusChange = { viewmodel.onEvent(OnAddSizeEvent.ChangeFocusGhad(it)) },
                        modifier = Modifier.weight(1f)
                    )
                 Spacer(modifier = Modifier.weight(2f))
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                   Button(onClick = {viewmodel.onEvent(OnAddSizeEvent.SaveSize)  }) {
                       Text(text = stringResource(id = R.string.save_person))
                   }
                }
            }
        })


}