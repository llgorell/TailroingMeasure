package com.example.tailormeasure.presentation.person.persons.components

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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
import androidx.core.app.ActivityCompat
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
    onClick: () -> Unit,
    viewModel: AddEditPersonViewModel = hiltViewModel(),
) {
    var REQUEST_PHONE_CALL= 1
    val context = LocalContext.current
    val activity = LocalContext.current as Activity
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(
            vertical = 8.dp
        )
        .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        backgroundColor = MaterialTheme.colors.onSecondary) {
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
                        getPermissionCall(context,activity,person,REQUEST_PHONE_CALL)

                    }) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = "call")
                    }
                    IconButton(onClick = {
                        val uri = Uri.parse("smsto:${person.phone}")
                        val intent = Intent(Intent.ACTION_SENDTO, uri)
                        intent.putExtra("sms_body", "${person.name}سلام ")
                        context.startActivity(intent)
                    }) {
                        Icon(imageVector = Icons.Default.Email , contentDescription = "sms")
                    }
                }
            }


            }
        }
    }
private fun call(person: Person, context: Context) {
    val dialInetnt = Intent(Intent.ACTION_CALL)
    dialInetnt.data = Uri.parse("tel:" + person.phone)
    context.startActivity(dialInetnt)
}
private fun getPermissionCall(context : Context,activity: Activity,person: Person,cod :Int){
    if (ActivityCompat.checkSelfPermission(context , android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(activity,
            arrayOf(android.Manifest.permission.CALL_PHONE),
            cod)
    }else {
        call(person,context)
    }
}


