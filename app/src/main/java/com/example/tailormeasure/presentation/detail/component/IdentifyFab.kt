package com.example.tailormeasure.presentation.detail.component

sealed class IdentifyFab(val name : String){

    object Dress : IdentifyFab("dress_identify")
    object Size : IdentifyFab("size_identify")
}
