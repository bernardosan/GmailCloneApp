package com.example.gmailcloneapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailcloneapp.ui.theme.GmailCloneAppTheme

@Composable
fun TopContentBar() {
    Row(modifier = Modifier.padding(top = 8.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Primary",
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(2.0f))
        Icon(imageVector = Icons.Default.FilterList,
            contentDescription = "Filter",
            modifier = Modifier.clickable {  }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    GmailCloneAppTheme {
    }
}