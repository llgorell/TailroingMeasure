package com.example.tailormeasure.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tailormeasure.presentation.detail.component.IdentifyFab
import com.example.tailormeasure.presentation.detail.component.MainFabItem
import com.example.tailormeasure.presentation.detail.component.MultiFloatingActionButton
import com.example.tailormeasure.presentation.detail.component.MultiFloatingState
import com.example.tailormeasure.presentation.util.Screens
import com.example.tailormeasure.presentation.util.TabItem
import com.example.tailormeasure.presentation.util.Tabs
import com.example.tailormeasure.presentation.util.TabsContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()
    val tabs = listOf(
        TabItem.DressTab,
        TabItem.SizeTab
    )
    var multiFloatingState by remember {
        mutableStateOf(MultiFloatingState.COLLAPSED)
    }
    val statePager = rememberPagerState()
    val state = viewModel.state.value
    val id : Int = -1

    val itemsFab = listOf(
        MainFabItem(
            icon = ImageBitmap.imageResource(id = com.example.tailormeasure.R.drawable.index),
            label = stringResource(id = com.example.tailormeasure.R.string.add_dress),
            identifier = IdentifyFab.Dress
        ),
        MainFabItem(
            icon = ImageBitmap.imageResource(id = com.example.tailormeasure.R.drawable.index),
            label = stringResource(id = com.example.tailormeasure.R.string.add_size),
            identifier = IdentifyFab.Size
        )
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar {
                state.person?.let {
                    Text(text = it.name)
                }
            }
        },
        floatingActionButton = {
            MultiFloatingActionButton(
                multiFloatingState = multiFloatingState,
                onMultiFabStateChange = {
                    multiFloatingState = it
                },
                items = itemsFab,
                onClickFab = {
                    when (it.identifier) {
                        is IdentifyFab.Dress -> {
                            navController.navigate(Screens.AddEditDressScreen.route + "?phone=${state.person?.phone}&id=${id}")
                        }
                        is IdentifyFab.Size -> {
                            navController.navigate(Screens.AddEditSizeScreen.route)

                        }
                    }
                }
            )
        }
    )
            { paddingValues ->

                Column(modifier = Modifier.padding(paddingValues)) {
                    Tabs(tabs = tabs, pagerState = statePager)
                    TabsContent(tabs = tabs, pagerState = statePager)
                }
            }
        }