package com.example.gmailcloneapp.components

import com.example.gmailcloneapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmailcloneapp.GmailApp
import com.example.gmailcloneapp.ui.theme.DarkGraySurfaceGoogle
import com.example.gmailcloneapp.ui.theme.GmailCloneAppTheme
import com.example.gmailcloneapp.ui.theme.LightGraySurfaceGoogle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@Composable
fun HomeAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope,
               openDialog: MutableState<Boolean>
){

    val darkTheme: Boolean = isSystemInDarkTheme()

    Box(modifier = Modifier.padding(20.dp,10.dp)) {
        Card(
            modifier = Modifier.requiredHeight(50.dp),
            shape = RoundedCornerShape(30.dp),
            backgroundColor = if(darkTheme) DarkGraySurfaceGoogle else LightGraySurfaceGoogle,
            elevation = 6.dp
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ){
                //Divider(color = Color.Transparent, modifier = Modifier.fillMaxHeight().width(2.dp))
                IconButton(onClick = {
                    scope.launch{
                        scaffoldState.drawerState.open()
                    }
                }){
                    Icon(Icons.Default.Menu, "Menu")
                }
                //Divider(color = Color.Transparent, modifier = Modifier.fillMaxHeight().width(0.dp))
                Text(text = "Search in e-mails", modifier = Modifier.weight(2.0f))
                Divider(color = Color.Transparent, modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp))
                Image(painter = painterResource(id = R.drawable.ic_user_place_holder),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .clickable {
                            openDialog.value = true
                        }
                )
                if(openDialog.value == true){
                    AccountsDialog(openDialog = openDialog)
                }
                Divider(color = Color.Transparent, modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp))
            }

        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    GmailCloneAppTheme {
        GmailApp()
    }
}