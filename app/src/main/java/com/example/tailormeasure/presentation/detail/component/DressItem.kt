package com.example.tailormeasure.presentation.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tailormeasure.R
import com.example.tailormeasure.domain.model.Dress

@Composable
fun DressItem(dress : Dress) {
    
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp), backgroundColor = MaterialTheme.colors.primary) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Column() {
                Card(modifier = Modifier
                    .size(42.dp)
                    .scale(1f), shape = CircleShape) {
                    Image(imageVector = Icons.Default.AccountBox, contentDescription = "picture of dress")
                }
                Image(imageVector = if(dress.not_paid) Icons.Default.Close else Icons.Default.CheckCircle, contentDescription = "pay or not")

            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(Modifier.wrapContentWidth()) {

                Row(Modifier.padding(horizontal = 8.dp)) {
                    Text(text = stringResource(id = R.string.name_dress))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = dress.name)
                }
                Row(Modifier.padding(horizontal = 8.dp)) {
                    Text(text = stringResource(id = R.string.price))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = dress.price.toString())
                }
                Row(modifier = Modifier.padding(horizontal = 8.dp)) {
                    Text(text = stringResource(id = R.string.paid))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = dress.paid.toString())
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.wrapContentHeight()
            ) {
                Text(text = stringResource(id = R.string.start_date))
                Text(text = stringResource(id = R.string.account_balance))
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.wrapContentHeight()
                ) {
                Text(text = dress.start_date)
                Text(text = dress.account_balance.toString())
            }
        }
    }
}