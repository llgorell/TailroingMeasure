package com.example.tailormeasure.presentation.dress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tailormeasure.presentation.detail.DetailViewModel
import com.example.tailormeasure.presentation.detail.component.DressItem

@Composable
fun DressScreen(viewmodel: DetailViewModel = hiltViewModel()) {
    val state = viewmodel.state.value
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)){
        items(state.listDress){ dress ->
            DressItem(dress = dress)
        }
    }
}