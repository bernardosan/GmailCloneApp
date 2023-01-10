package com.example.gmailcloneapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailcloneapp.utils.mailList
import com.example.gmailcloneapp.models.MailData

@Composable
fun MailList(paddingValues: PaddingValues, scrollState: ScrollState = rememberScrollState()){
    Box(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .scrollable(scrollState, Orientation.Vertical)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)){
            items(mailList){
               mailData -> MailItem(mailData = mailData)
            }
        }
    }
}

@Composable
fun MailItem(mailData: MailData){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ){
        Card(modifier = Modifier
            .padding(end = 16.dp)
            .size(40.dp)
            .clip(CircleShape),
        backgroundColor = Color.Gray){
            Text(text = mailData.userName[0].toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
            )
        }
        Column(modifier = Modifier.weight(2.0f)) {
            Text(text = mailData.userName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
            )
            Text(text = mailData.subject,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = mailData.content,
                fontSize = 14.sp
            )
        }
        Column {
            Text(text = mailData.timestamp, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(15.dp)
                    .padding(top = 16.dp))
            {
                Image(imageVector = Icons.Outlined.StarOutline, contentDescription = "")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview(){
    MailItem(
        mailData = MailData(
            4,
            "Robert",
            "Meeting",
            "This is regarding an important meeting",
            "22:22"))
}
