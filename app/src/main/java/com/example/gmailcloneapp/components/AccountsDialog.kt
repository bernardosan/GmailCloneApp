package com.example.gmailcloneapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.gmailcloneapp.R
import com.example.gmailcloneapp.models.AccountData
import com.example.gmailcloneapp.utils.accountList

@ExperimentalComposeUiApi
@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>){
    Dialog(
        onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        AccountsDialogUI(openDialog = openDialog)
    }
}

@Composable
fun AccountsDialogUI(openDialog: MutableState<Boolean>, modifier: Modifier = Modifier
    .padding(start = 16.dp, end = 16.dp)
    .clip(RoundedCornerShape(8.dp))){
    Card(modifier.background(MaterialTheme.colors.surface), elevation = 0.dp){
        Column(modifier = Modifier
            .padding(start = 0.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)) {
            Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = { openDialog.value = false }, modifier = Modifier.padding(0.dp)) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "")
                }
                Image(painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "Google",
                    modifier = Modifier
                        .size(22.dp)
                        .weight(2.0f))

            }

            AccountItem(account = accountList[0])

            Row(modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
                Card(modifier.padding(start = 14.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray),
                    backgroundColor = MaterialTheme.colors.surface)
                {
                    Text(text = "Google Account",
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 18.dp, end = 18.dp),
                        textAlign = TextAlign.Center
                    )

                }
                Spacer(modifier.width(8.dp))
            }
            Divider(modifier.padding(top = 16.dp))

            AccountItem(account = accountList[1])
            Spacer(modifier.width(8.dp))
            AccountItem(account = accountList[2])


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 16.dp)) {
                Image(
                    imageVector = Icons.Outlined.PersonAddAlt,
                    contentDescription = "Add account"
                )
                Column(
                    modifier = Modifier
                        .weight(2.0f)
                        .padding(start = 16.dp, bottom = 16.dp)
                ) {
                    Text(text = "Add another account",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 16.dp)) {
                Image(
                    imageVector = Icons.Outlined.ManageAccounts,
                    contentDescription = "Add account"
                )
                Column(
                    modifier = Modifier
                        .weight(2.0f)
                        .padding(start = 16.dp, bottom = 16.dp)
                ) {
                    Text(text = "Manage accounts on this device",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
            }

            Divider(modifier.padding(top = 16.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){

                Text(text = "Privacy Policy")

                Card(shape = CircleShape,
                    backgroundColor = Color.Black,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(3.dp)
                ){

                }
                Text(text = "Terms of Service")

            }


        }
    }
}

@Composable
fun AccountItem(account: AccountData){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 24.dp, top = 16.dp)){
        Image(painter = painterResource(id = account.icon!!),
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier
            .weight(2.0f)
            .padding(start = 16.dp, bottom = 16.dp)) {
            Text(text = account.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
            Text(text = account.email, fontSize = 12.sp)
        }
        Text(text = if(account.unReadEmails < 100) account.unReadEmails.toString() else "99+",
            modifier = Modifier.padding(end = 16.dp),
            fontSize = 14.sp
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AccountsDialogUiPreview(){
    AccountsDialogUI(openDialog = mutableStateOf(value = false))
}



