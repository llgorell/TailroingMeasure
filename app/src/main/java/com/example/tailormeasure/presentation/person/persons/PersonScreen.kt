package com.example.tailormeasure.presentation.person.persons

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tailormeasure.R
import com.example.tailormeasure.presentation.person.persons.components.PersonItem
import com.example.tailormeasure.presentation.person.persons.components.SearchBar
import com.example.tailormeasure.presentation.person.persons.components.SectionOrder
import com.example.tailormeasure.presentation.util.Screens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PersonScreen(
    navController: NavController,
    viewmodel: PersonsViewModel = hiltViewModel()
) {

    val state by viewmodel.state
    val query = viewmodel.query.value
    val scaffoldState = rememberScaffoldState()
    val scopeCoroutine = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screens.AddEditScreen.route) },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add person"
                )
            }
        },
        scaffoldState = scaffoldState
    ) {
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