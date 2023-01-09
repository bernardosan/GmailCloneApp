package com.example.gmailcloneapp.models

import java.io.Serializable

data class MailData(
    val mailId: Int,
    val userName: String,
    val subject: String,
    val content: String,
    val timestamp: String = ""
)
