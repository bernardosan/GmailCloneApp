package com.example.gmailcloneapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailcloneapp.components.DrawerMenu
import com.example.gmailcloneapp.components.HomeAppBar
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
        drawerContent = {
            DrawerMenu(scrollState)
        }
    ){

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneAppTheme {
    }
}