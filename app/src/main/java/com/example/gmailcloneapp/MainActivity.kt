package com.example.gmailcloneapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailcloneapp.components.*
import com.example.gmailcloneapp.ui.theme.BarColorsTheme
import com.example.gmailcloneapp.ui.theme.GmailCloneAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GmailCloneAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GmailApp()
                }
            }

        }
    }
}

@Composable
fun GmailApp() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState = scaffoldState, scope = coroutineScope)},
        bottomBar = { BottomNavigationMenu() },
        drawerContent = {
            DrawerMenu(scrollState)
        },
        drawerShape = customShape(),
        drawerBackgroundColor = Color(0xFFEAF1FB)

    ){

        MailList(paddingValues = it)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneAppTheme {
    }
}