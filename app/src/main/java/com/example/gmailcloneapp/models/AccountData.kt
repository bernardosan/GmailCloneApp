package com.example.gmailcloneapp.models

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.vector.ImageVector

data class AccountData(
    val userId: String,
    val name: String,
    val email: String,
    val icon: Int? = null,
    val unReadEmails: Int
)
