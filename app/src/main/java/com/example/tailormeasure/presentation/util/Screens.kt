package com.example.tailormeasure.presentation.util

sealed class Screens(val route : String) {
    object PersonScreen : Screens("person_screen")
    object AddEditScreen : Screens("addEdit_screen")
    object DetailScreen : Screens("detail_screen")
    object AddEditSizeScreen : Screens("add_size_screen")
    object AddEditDressScreen : Screens("add_dress_screen")

}