package com.example.tailormeasure.presentation.person.persons

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tailormeasure.R
import com.example.tailormeasure.presentation.person.add_eddit_person.AddEditPersonEvent
import com.example.tailormeasure.presentation.person.add_eddit_person.AddEditPersonViewModel
import com.example.tailormeasure.presentation.person.persons.components.PersonItem
import com.example.tailormeasure.presentation.person.persons.components.SearchBar
import com.example.tailormeasure.presentation.person.persons.components.SectionOrder
import com.example.tailormeasure.presentation.util.InputTextField
import com.example.tailormeasure.presentation.util.Screens
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PersonScreen(
    navController: NavController,
    viewmodel: PersonsViewModel = hiltViewModel(),
    viewmodelAdd: AddEditPersonViewModel = hiltViewModel(),
) {

    val state by viewmodel.state
    val query = viewmodel.query.value

    val name = viewmodelAdd.name.value
    val family = viewmodelAdd.family.value
    val phone = viewmodelAdd.phone.value

    var text = remember {
        ""
    }

    val bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val stateScaffold = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)
    val scaffoldState = rememberScaffoldState()
    val scopeCoroutine = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewmodelAdd.eventFlow.collectLatest { event ->
            when (event) {
                is AddEditPersonViewModel.UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AddEditPersonViewModel.UiEvent.SavePerson -> {
                    scopeCoroutine.launch {
                        bottomSheetState.collapse()
                    }
                }
            }

        }
    }

        BottomSheetScaffold(
            scaffoldState = stateScaffold,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scopeCoroutine.launch {
                            if (bottomSheetState.isCollapsed) {
                                bottomSheetState.expand()
                            } else {
                                bottomSheetState.collapse()
                            }
                        }
                    },
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add person"
                    )
                }
            },
            sheetPeekHeight = 0.dp,
            sheetBackgroundColor = MaterialTheme.colors.onSecondary,
            sheetContent = {
                Column(Modifier.padding(horizontal = 16.dp)) {


                InputTextField(text = name.text,
                    hint = name.hint,
                    singleLine = true,
                    errorMessage = name.errorMessage.toString(),
                    onChangeValue = { viewmodelAdd.onEvent(AddEditPersonEvent.EnteredName(it)) },
                    onFocusChange = { viewmodelAdd.onEvent(AddEditPersonEvent.ChangeNameFocus(it)) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                    )

                InputTextField(text = family.text,
                    hint = family.hint,
                    singleLine = true,
                    errorMessage = family.errorMessage.toString(),
                    onChangeValue = { viewmodelAdd.onEvent(AddEditPersonEvent.EnteredFamily(it)) },
                    onFocusChange = {
                        viewmodelAdd.onEvent(AddEditPersonEvent.ChangeFamilyFocus(it))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                    )

                InputTextField(text = phone.text,
                    hint = phone.hint,
                    textStyle = MaterialTheme.typography.caption,
                    singleLine = true,
                    errorMessage = phone.errorMessage.toString(),
                    onChangeValue = { viewmodelAdd.onEvent(AddEditPersonEvent.EnteredPhone(it)) },
                    onFocusChange = {
                        viewmodelAdd.onEvent(AddEditPersonEvent.ChangePhoneFocus(it))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    )
                    )
            }
                Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = { viewmodelAdd.onEvent(AddEditPersonEvent.SavePerson) }) {
                        Text(text = stringResource(id = R.string.save_person))
                    }
                }

                

            },
        ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = stringResource(id = R.string.note_tailor))
                IconButton(onClick = { viewmodel.onEvent(PersonEvent.ToggleOrderSection) }) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "orderSection"
                    )
                }
            }
            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                SectionOrder(
                    modifier = Modifier.fillMaxWidth(),
                    orderType = state.orderType,
                    onOrderChange = {
                        viewmodel.onEvent(PersonEvent.OrderType(it))
                    }
                )
            }
            SearchBar(
                text = query.query,
                hint = query.hintQuery,
                onValueChange = {
                    viewmodel.onEvent(PersonEvent.EnteredQuery(it))
                },
                onFocusChange = {
                    viewmodel.onEvent(PersonEvent.ChangeQueryFocus(it))
                },
                isHintVisible = query.isVisibleHint,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5
            )

            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(Modifier.fillMaxSize()) {
                items(state.personList) { person ->
                    PersonItem(person = person,
                        modifier = Modifier,
                        navController,
                        onClick = {
                            navController.navigate(Screens.DetailScreen.route + "/${person.phone}")
                        })
                }

            }

        }


    }

}