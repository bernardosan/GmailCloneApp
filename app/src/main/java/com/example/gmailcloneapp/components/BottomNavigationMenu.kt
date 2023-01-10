package com.example.gmailcloneapp.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.gmailcloneapp.models.BottomMenuData
import com.example.gmailcloneapp.ui.theme.DarkGraySurfaceGoogle
import com.example.gmailcloneapp.ui.theme.LightGraySurfaceGoogle

@Composable
fun BottomNavigationMenu(){
    val item = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )


    BottomNavigation(backgroundColor = if(isSystemInDarkTheme()) DarkGraySurfaceGoogle else LightGraySurfaceGoogle, contentColor = if(isSystemInDarkTheme()) Color.White else Color.Black) {
        item.forEach {
            BottomNavigationItem(
                label = {Text(text = it.title!!)},
                alwaysShowLabel = true,
                selected = false,
                onClick = { /*TODO*/},
                icon = {Icon(imageVector = it.icon!!, contentDescription = it.title)})
        }

    }
}