package com.example.navigate.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigate.components.MainButton
import com.example.navigate.components.MainIconButton
import com.example.navigate.components.Space
import com.example.navigate.components.TitleBar
import com.example.navigate.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BarrancoView(navController: NavController, id: Int, opcional: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Barranco view") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Magenta//Mi color favorito :)
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentBarrancoView(navController, id, opcional)
    }
}

@Composable
fun ContentBarrancoView(navController: NavController, id: Int, opcional: String?) {//el ? en String indica que puede recibir null
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Barranco View")
        Space()
        Space()
        TitleView(name = id.toString())
        Space()
        Space()
        if (opcional == ""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name = opcional.orEmpty())
        }
        MainButton(name = "Return Home", backColor = Color.Magenta, color = Color.White) {
            navController.navigate("Home")
        }
    }
}