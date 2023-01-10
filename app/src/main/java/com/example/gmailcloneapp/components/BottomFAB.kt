package com.example.gmailcloneapp.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailcloneapp.ui.theme.DarkGraySurfaceGoogle
import com.example.gmailcloneapp.ui.theme.LightGraySurfaceGoogle

@Composable
fun BottomFAB(scrollState: ScrollState){

    val bgColor = if(isSystemInDarkTheme()) DarkGraySurfaceGoogle else LightGraySurfaceGoogle

    if(scrollState.value > 100){
        ExtendedFloatingActionButton(text = {Text("Compose", fontSize = 16.sp)},
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Edit, "") },
            backgroundColor = bgColor,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.height(56.dp)
        )
    }else {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            backgroundColor = bgColor,
            shape = RoundedCornerShape(15.dp)
        ) {
            Icon(imageVector = Icons.Default.Edit, "")
        }
    }
}