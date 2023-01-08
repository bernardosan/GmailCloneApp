package com.example.gmailcloneapp.components

import com.example.gmailcloneapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmailcloneapp.GmailApp
import com.example.gmailcloneapp.ui.theme.GmailCloneAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope){
    Box(modifier = Modifier.padding(20.dp,10.dp)) {
        Card(
            modifier = Modifier.requiredHeight(50.dp),
            shape = RoundedCornerShape(30.dp),
            backgroundColor = Color(android.graphics.Color.parseColor("#EAF1FB")),
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
                Divider(color = Color.Transparent, modifier = Modifier.fillMaxHeight().width(12.dp))
                Text(text = "Search in e-mails", modifier = Modifier.weight(2.0f))
                Divider(color = Color.Transparent, modifier = Modifier.fillMaxHeight().width(2.dp))
                Image(painter = painterResource(id = R.drawable.ic_user_place_holder),
                contentDescription = "Profile",
                modifier = Modifier.size(30.dp).clip(CircleShape))
                Divider(color = Color.Transparent, modifier = Modifier.fillMaxHeight().width(2.dp))
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