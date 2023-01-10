package com.example.gmailcloneapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import kotlin.collections.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailcloneapp.models.DrawerMenuData

@Composable
fun DrawerMenu(scrollState: ScrollState){

    val menuList = listOf  (
        DrawerMenuData.Divider,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.HeaderAllLabels,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Schedule,
        DrawerMenuData.Outbox,
        DrawerMenuData.Draft,
        DrawerMenuData.AllMail,
        DrawerMenuData.HeaderGoogleApps,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.Divider,
        DrawerMenuData.Setting,
        DrawerMenuData.Help
    )

    Column(modifier = Modifier.verticalScroll(state = scrollState)) {
        Text( text = "Gmail",
            color = if(isSystemInDarkTheme()) Color.White else Color.Red,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 12.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        menuList.forEach {
            item -> when{
                item.isDivider -> {
                    Divider(modifier = Modifier.padding(bottom = 10.dp, top = 10.dp))
                }

                item.isHeader -> {
                    Text(text = item.title!!, fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 20.dp, bottom = 20.dp, top = 20.dp))
                }

                else -> {
                    MailDrawerItem(item = item)
                }

            }
        }
        
    }
}

@Composable
fun MailDrawerItem(item: DrawerMenuData){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(top = 16.dp)){
        Image(imageVector = item.icon!!,
            contentDescription = item.title!!,
            modifier = Modifier.weight(0.25f),
            colorFilter = if(isSystemInDarkTheme()) ColorFilter.tint(Color.White) else ColorFilter.tint(Color.Black)
        )
        Text(text = item.title, modifier = Modifier.weight(1.0f))
    }
}

@Composable
fun customShape() =  object : Shape {

    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: androidx.compose.ui.unit.LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(androidx.compose.ui.geometry.Rect(0f,0f,size.width*8/9, size.height))
    }
}