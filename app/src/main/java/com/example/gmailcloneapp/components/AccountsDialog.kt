package com.example.gmailcloneapp.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.window.Dialog

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>){
    Dialog(onDismissRequest = { openDialog.value = false}){

    }
}