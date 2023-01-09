package com.example.gmailcloneapp.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.gmailcloneapp.models.BottomMenuData

@Composable
fun BottomNavigationMenu(){
    val item = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )
    
    BottomNavigation(backgroundColor = Color.White, contentColor = Color.Black) {
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