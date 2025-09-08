package com.harshit.demokmp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.harshit.demokmp.navigation.Route
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RegistrationPage(onNavigate:(Route)-> Unit,onBack:()-> Unit) {

    Surface(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = { RegisterTopBar("Register",onBack) }
        ) {


        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterTopBar(title: String,onBack:()-> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        },
        navigationIcon = {

            IconButton(onClick = {onBack()}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewRegistrationPage() {
    RegistrationPage(onNavigate = {}, onBack = {})
}