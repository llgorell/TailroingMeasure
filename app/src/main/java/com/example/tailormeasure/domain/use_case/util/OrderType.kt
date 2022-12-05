package com.example.tailormeasure.domain.use_case.util

sealed class OrderType{
    object Ascending : OrderType()
    object Descending : OrderType()
}
