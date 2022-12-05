package com.example.tailormeasure.presentation.util

import androidx.compose.runtime.Composable
import com.example.tailormeasure.presentation.dress.DressScreen
import com.example.tailormeasure.presentation.size_body.SizeBodyScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem( var title: String, var screen: ComposableFun) {

    object DressTab : TabItem( "لباس", { DressScreen() })
    object SizeTab : TabItem( "سایز", { SizeBodyScreen() })

}
