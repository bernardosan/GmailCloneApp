package com.example.gmailcloneapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailcloneapp.components.*
import com.example.gmailcloneapp.ui.theme.*

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
    val openDialog = remember{
        mutableStateOf(false)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState = scaffoldState, scope = coroutineScope, openDialog = openDialog)},
        bottomBar = { BottomNavigationMenu() },
        drawerContent = {
            DrawerMenu(scrollState)
        },
        floatingActionButton = {BottomFAB(scrollState = scrollState)},
        drawerShape = customShape(),
        drawerContentColor = if(isSystemInDarkTheme()) Color.White else Color.Black,
        drawerBackgroundColor = if(isSystemInDarkTheme()) DarkGraySurfaceGoogle else LightGraySurfaceGoogle

    ){

        MailList(paddingValues = it, scrollState)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneAppTheme {
    }
}