package com.example.tailormeasure.presentation.dress

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tailormeasure.presentation.dress.component.InputTextField
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AddDressScreen(navController: NavController,viewModel: AddDressViewModel = hiltViewModel()) {

    val name = viewModel.name.value
    val price = viewModel.price.value
    val paid = viewModel.paid.value
    val startDate = viewModel.startDate.value
    val deliveryDate = viewModel.deliveryDate.value

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true ){
        viewModel.eventSharedFlow.collectLatest { event->
            when(event){
                is AddDressViewModel.UiEvent.ShowSnackBar-> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message
                    )
                }
                is AddDressViewModel.UiEvent.SaveDress -> {
                    navController.navigateUp()
                }
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        InputTextField(
            text = name.text,
            hint = name.hint,
            errorMessage = name.errorMessage ?: "",
            onChangeValue = {viewModel.onEvent(AddDressEvent.EnteredName(it))} ,
            onFocusChange = {viewModel.onEvent(AddDressEvent.ChangeFocusName(it))},
            isError = name.isError,
            singleLine = true,
            textStyle = MaterialTheme.typography.body2,
            isVisibleHint = name.isHintVisible
        )
        InputTextField(
            text = price.text,
            hint = price.hint,
            errorMessage = price.errorMessage ?: "",
            onChangeValue = {viewModel.onEvent(AddDressEvent.EnteredPrice(it))} ,
            onFocusChange = {viewModel.onEvent(AddDressEvent.ChangeFocusPrice(it))},
            isError = price.isError,
            singleLine = true,
            textStyle = MaterialTheme.typography.body2,
            isVisibleHint = price.isHintVisible
        )
        InputTextField(
            text = paid.text,
            hint = paid.hint,
            errorMessage = paid.errorMessage ?: "",
            onChangeValue = {viewModel.onEvent(AddDressEvent.EnteredPaid(it))} ,
            onFocusChange = {viewModel.onEvent(AddDressEvent.ChangeFocusPaid(it))},
            isError = paid.isError,
            singleLine = true,
            textStyle = MaterialTheme.typography.body2,
            isVisibleHint = paid.isHintVisible
        )
        InputTextField(
            text = startDate.text,
            hint = startDate.hint,
            errorMessage = startDate.errorMessage ?: "",
            onChangeValue = {viewModel.onEvent(AddDressEvent.EnteredStartDate(it))} ,
            onFocusChange = {viewModel.onEvent(AddDressEvent.ChangeFocusStartDate(it))},
            isError = startDate.isError,
            singleLine = true,
            textStyle = MaterialTheme.typography.body2,
            isVisibleHint = startDate.isHintVisible
        )
        InputTextField(
            text = deliveryDate.text,
            hint = deliveryDate.hint,
            errorMessage = deliveryDate.errorMessage ?: "",
            onChangeValue = {viewModel.onEvent(AddDressEvent.EnteredDeliveryDate(it))} ,
            onFocusChange = {viewModel.onEvent(AddDressEvent.ChangeFocusDeliveryDate(it))},
            isError = deliveryDate.isError,
            singleLine = true,
            textStyle = MaterialTheme.typography.body2,
            isVisibleHint = deliveryDate.isHintVisible
        )

        Button(onClick = { viewModel.onEvent(AddDressEvent.saveDress) }) {

            Text(text = "save dress")
        }

    }

}
