package com.example.gmailcloneapp.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData (
    val icon: ImageVector? = null,
    val title: String? = null
){
    object Mail: BottomMenuData(
        icon = Icons.Outlined.Mail,
        title = "Mail"
    )
    object Meet: BottomMenuData(
        icon = Icons.Outlined.VideoCall,
        title = "Meet"
    )
}