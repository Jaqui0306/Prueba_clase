package com.example.prueba2_1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prueba2_1.ui.theme.Prueba2_1Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prueba2_1Theme {
                ViewContainer()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    device = "spec:width=411dp,height=891dp,orientation=portrait",
    locale = "es-rMX"
)
@Composable
fun ViewContainer() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val snackbarMessage = stringResource(R.string.snackbar_message)
    val snackbarAction = stringResource(R.string.snackbar_action)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.home_screen)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    titleContentColor = Color.Black
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.back_btn_desc),
                            tint = Color.Black
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.bottom_app_bar),
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    val result = snackbarHostState.showSnackbar(
                        message = snackbarMessage,
                        actionLabel = snackbarAction,
                        duration = SnackbarDuration.Short
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        // Aquí va lo que haga el botón de acción del Snackbar
                    }
                }
            }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = stringResource(R.string.home_fab_text)
                )
            }
        }
    ) { innerPadding ->
        ContentView(innerPadding)
    }
}

@Composable
fun ContentView(innerPadding: PaddingValues) {
    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.imagen1),
                contentDescription = "Ilustración de Android",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )

            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_back_hand_24),
                    contentDescription = "Botón de reacción",
                    modifier = Modifier
                        .clickable { counter++ }
                        .padding(start = 12.dp)
                )
                Text(
                    text = counter.toString(),
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Text(
                text = stringResource(R.string.materia),
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.nombre),
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.apellidos),
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.imagen2),
                        contentDescription = "Mobile Apps",
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.imagen3),
                        contentDescription = "Mobile Apps",
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.imagen4),
                        contentDescription = "Mobile Apps",
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.imagen5),
                        contentDescription = "Mobile Apps",
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.imagen6),
                        contentDescription = "Mobile Apps",
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}