package com.example.tailormeasure.presentation.person.persons.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    text: String,
    hint :String,
    modifier : Modifier = Modifier,
    isHintVisible : Boolean = true,
    onValueChange : (String) -> Unit,
    textStyle : TextStyle = TextStyle(),
    singleLine : Boolean = false,
    onFocusChange : (FocusState) -> Unit
) {
    Box(modifier = modifier.fillMaxWidth()) {

        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .background(MaterialTheme.colors.secondary, CircleShape)
                .onFocusChanged {
                    onFocusChange(it)
                }
        )
        if (isHintVisible){
            Text(text = hint , style = textStyle, color = Color.DarkGray, modifier = modifier.padding(horizontal = 8.dp))
        }
    }
}