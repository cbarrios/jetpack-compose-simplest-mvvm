package com.lalosapps.simplestmvvm

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lalosapps.simplestmvvm.ui.theme.SimplestMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplestMVVMTheme {
                val viewModel: MainViewModel = viewModel()
                MyApp(
                    counter = viewModel.state,
                    onIncrement = viewModel::onIncrementCounter
                )
            }
        }
    }
}

@Composable
fun MyApp(
    counter: Int,
    onIncrement: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onIncrement) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "$counter")
        }
    }
}

@Preview("Light mode")
@Preview("Dark mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    SimplestMVVMTheme {
        MyApp(0) {}
    }
}