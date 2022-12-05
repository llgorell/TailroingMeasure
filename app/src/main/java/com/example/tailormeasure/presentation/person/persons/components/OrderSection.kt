package com.example.tailormeasure.presentation.person.persons.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tailormeasure.domain.use_case.util.OrderType

@Composable
fun SectionOrder(
    modifier: Modifier = Modifier,
    orderType: OrderType = OrderType.Ascending,
    onOrderChange: (OrderType) -> Unit
) {

    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {

            DefaultRadioButton(
                text = "Ascending",
                selected = orderType is OrderType.Ascending,
                onSelected = { onOrderChange(OrderType.Ascending) })
            DefaultRadioButton(
                text = "Descending",
                selected = orderType is OrderType.Descending,
                onSelected = { onOrderChange(OrderType.Descending) })
        }
    }
}