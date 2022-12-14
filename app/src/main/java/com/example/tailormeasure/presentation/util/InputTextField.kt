package com.example.tailormeasure.presentation.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun InputTextField(
    text: String,
    hint: String,
    errorMessage: String,
    singleLine: Boolean = false,
    isError : Boolean = false,
    textStyle: TextStyle = TextStyle(),
    isVisibleHint : Boolean = true,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    onChangeValue: (String) -> Unit,
    onFocusChange: (FocusState) -> Unit,
) {
    Box(modifier = modifier) {
        OutlinedTextField(
            value = text,
            onValueChange = {onChangeValue(it)},
            singleLine = singleLine,
            label = {
                if (isVisibleHint && !isError){
                    Text(text = hint, style = textStyle, color = Color.DarkGray)
                }
                if (isError ){
                    Text(text = errorMessage, color = MaterialTheme.colors.error, style = textStyle)
                }
            },
            keyboardOptions = keyboardOptions
            ,
            modifier =Modifier.fillMaxWidth()
                .onFocusChanged { onFocusChange(it) }
            )
    }


}