package com.harshit.demokmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.harshit.demokmp.viewmodel.AndroidLoginEntryPoint
import com.harshit.demokmp.viewmodel.AndroidLoginViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val androidVM: AndroidLoginViewModel = koinViewModel()
            AndroidLoginEntryPoint(androidVM, true)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val androidVM: AndroidLoginViewModel = koinViewModel()
    AndroidLoginEntryPoint(androidVM, true)
}