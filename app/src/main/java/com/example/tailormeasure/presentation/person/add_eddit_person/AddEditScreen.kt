package com.example.tailormeasure.presentation.person.add_eddit_person

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tailormeasure.presentation.person.persons.components.SearchBar
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddEditScreen(
    navController: NavController,
    viewModel: AddEditPersonViewModel = hiltViewModel()
) {
    val scaFFoldState = rememberScaffoldState()
    val name = viewModel.name.value
    val family = viewModel.family.value
    val phone = viewModel.phone.value

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event){
                is AddEditPersonViewModel.UiEvent.ShowSnackBar -> {
                    scaFFoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AddEditPersonViewModel.UiEvent.SavePerson -> {
                    navController.navigateUp()
                }
            }

        }
    }
    Scaffold(
        Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(AddEditPersonEvent.SavePerson)
            }, backgroundColor = MaterialTheme.colors.primary) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "save person"
                )
            }
        },
        scaffoldState = scaFFoldState
    ) {
        Column(verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {

            SearchBar(
                text = name.text,
                hint = name.hint,
                onValueChange = { viewModel.onEvent(AddEditPersonEvent.EnteredName(it)) },
                onFocusChange = { viewModel.onEvent(AddEditPersonEvent.ChangeNameFocus(it)) },
                isHintVisible = name.isHintVisible,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5
                )
            SearchBar(
                text = family.text,
                hint = family.hint,
                onValueChange = { viewModel.onEvent(AddEditPersonEvent.EnteredFamily(it)) },
                onFocusChange = { viewModel.onEvent(AddEditPersonEvent.ChangeFamilyFocus(it)) },
                isHintVisible = family.isHintVisible,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5
                )
            SearchBar(
                text = phone.text,
                hint = phone.hint,
                onValueChange = { viewModel.onEvent(AddEditPersonEvent.EnteredPhone(it)) },
                onFocusChange = { viewModel.onEvent(AddEditPersonEvent.ChangePhoneFocus(it)) },
                isHintVisible = phone.isHintVisible,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5
                )


        }
    }

}