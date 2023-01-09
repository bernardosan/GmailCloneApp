package com.example.gmailcloneapp.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import com.example.gmailcloneapp.models.MailData

@Composable
fun MailList(paddingValues: PaddingValues){
    Box() {
        // TODO: create a mock data to show the list
    }
}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ){
        Card(modifier = Modifier
            .padding(end = 8.dp)
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
            Text(text = mailData.timestamp)
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(15.dp)
                    .padding(top = 16.dp))
            {
                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "")

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
