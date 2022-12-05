package com.example.tailormeasure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tailormeasure.presentation.detail.DetailScreen
import com.example.tailormeasure.presentation.dress.AddDressScreen
import com.example.tailormeasure.presentation.person.add_eddit_person.AddEditScreen
import com.example.tailormeasure.presentation.person.persons.PersonScreen
import com.example.tailormeasure.presentation.size_body.AddSizeScreen
import com.example.tailormeasure.presentation.util.Screens
import com.example.tailormeasure.ui.theme.TailorMeasureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TailorMeasureTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ){
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        NavHost(navController = navController, startDestination = Screens.PersonScreen.route){
                            composable(Screens.PersonScreen.route){
                                PersonScreen(navController)
                            }
                            composable(Screens.AddEditScreen.route){
                                AddEditScreen(navController = navController)
                            }
                            composable(Screens.DetailScreen.route + "/{phone}",
                                arguments = listOf(
                                    navArgument(
                                        name = "phone"
                                    ){
                                        type = NavType.StringType
                                        defaultValue = "1"
                                    }

                                )
                            ){
                                DetailScreen(navController)
                            }
                            composable(Screens.AddEditDressScreen.route + "?phone={phone}&id={id}",
                                arguments = listOf(
                                    navArgument(
                                        name = "phone"
                                    ){
                                        type = NavType.StringType
                                        defaultValue = "1"
                                    },
                                    navArgument(
                                        name = "id"
                                    ){
                                        type = NavType.IntType
                                        defaultValue = -1
                                    }
                                )
                            ){
                                AddDressScreen(navController)
                            }
                            composable(Screens.AddEditSizeScreen.route){
                                AddSizeScreen()
                            }
                        }

                    }
                }

            }
        }
    }
}

