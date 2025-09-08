package com.harshit.demokmp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harshit.demokmp.navigation.Route
import demokmp.composeapp.generated.resources.Res
import demokmp.composeapp.generated.resources.ic_app_logo_512
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RegistrationPage(onNavigate: (Route) -> Unit, onBack: () -> Unit) {

    Surface(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = { RegisterTopBar("Register", onBack) }
        ) { paddingValues ->

            Column(
                modifier = Modifier.fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(14.dp)
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .size(130.dp),
                    painter = painterResource(Res.drawable.ic_app_logo_512),
                    contentDescription = "Logo"
                )


                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Full Name") },
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Person"
                        )
                    }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Email") },
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email"
                        )
                    }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Phone") },
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Phone"
                        )
                    }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Password") },
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password"
                        )
                    }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 60.dp),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Confirm Password") },
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Confirm Password"
                        )
                    }
                )


                Button(modifier = Modifier.fillMaxWidth(), onClick = {}) {

                    Text(text = "Registration", style = MaterialTheme.typography.bodyLarge)

                }


            }


        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterTopBar(title: String, onBack: () -> Unit) {
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

            IconButton(onClick = { onBack() }) {
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
fun PreviewRegistrationPage() {
    RegistrationPage(onNavigate = {}, onBack = {})
}