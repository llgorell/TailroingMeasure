package com.example.tailormeasure.presentation.person.persons.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tailormeasure.R
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.presentation.person.add_eddit_person.AddEditPersonViewModel

@Composable
fun PersonItem(
    person: Person,
    modifier: Modifier = Modifier,
    navController: NavController,
    onClick : () -> Unit,
    viewModel: AddEditPersonViewModel = hiltViewModel()
    ) {

    val context = LocalContext.current
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(
            vertical = 8.dp
        )
        .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        backgroundColor = MaterialTheme.colors.primary) {
        Row(modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)) {

            Column(Modifier.wrapContentWidth()) {

                Row(Modifier.padding(horizontal = 8.dp)) {
                    Text(text = stringResource(id = R.string.first_name))
                    Text(text = person.name)
                }
                Row(modifier.padding(horizontal = 8.dp)) {
                    Text(text = stringResource(id = R.string.last_name))
                    Text(text = person.family)
                }
                Row(modifier.padding(horizontal = 8.dp)) {
                    Text(text = stringResource(id = R.string.phone_number))
                    Text(text = person.phone)
                }
            }

                Spacer(modifier = Modifier.weight(1f))
            Column( verticalArrangement = Arrangement.Bottom, modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.Bottom)) {
                Row() {
                    IconButton(onClick = {
                        /* viewModel.onEvent(AddEditPersonEvent.Call(person.phone))*//**/
                        val dialInetnt = Intent(Intent.ACTION_CALL)
                        dialInetnt.data = Uri.parse("tel:" + person.phone)
                        context.startActivity(dialInetnt)

                    }) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = "call")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Email , contentDescription = "sms")
                    }
                }
            }


            }
        }
    }
