package com.harshit.demokmp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harshit.demokmp.navigation.Route
import demokmp.composeapp.generated.resources.Res
import demokmp.composeapp.generated.resources.ic_app_logo_512
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SelectionTypePage(onNavigate:(Route)-> Unit,onBack: () -> Unit) {

    Surface(modifier = Modifier.fillMaxSize()) {

        Scaffold(topBar = { SelectionTopBar("Selection Type",onBack) }) { paddingValues ->

            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).padding(14.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    modifier = Modifier
                        .padding(bottom = 60.dp)
                        .size(130.dp),
                    painter = painterResource(Res.drawable.ic_app_logo_512),
                    contentDescription = "Logo"
                )

                Button(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp), onClick = {}) {
                    Text(
                        text = "Takeaway",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif
                        )
                    )
                }

                Button(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp), onClick = {}) {
                    Text(
                        text = "Grocery",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif
                        )
                    )
                }


            }


        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionTopBar(title: String,onBack: () -> Unit) {
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
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red)
    )
}

@Preview
@Composable
fun PreviewSelectionTypePage() {
    SelectionTypePage(onNavigate = {}, onBack = {})
}