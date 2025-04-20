package com.aliozdemir.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliozdemir.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardAppScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardAppScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFD2E8D4)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileSection()
        ContactSection()
    }
}

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 200.dp)
    ) {
        Logo()
        NameAndTitle()
    }
}

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.android_logo),
        contentDescription = null,
        modifier = Modifier
            .size(150.dp)
    )
}

@Composable
fun NameAndTitle() {
    Text(
        text = stringResource(R.string.full_name),
        fontSize = 50.sp,
        modifier = Modifier.padding(bottom = 10.dp)
    )
    Text(
        text = stringResource(R.string.title),
        color = Color(0xFF016C3B),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier
            .padding(bottom = 40.dp)
    ) {
        ContactInfoItem(
            iconId = R.drawable.call_24px,
            infoText = "+11 (123) 444 555 666"
        )
        ContactInfoItem(
            iconId = R.drawable.share_24px,
            infoText = "@AndroidDev"
        )
        ContactInfoItem(
            iconId = R.drawable.mail_24px,
            infoText = "jen.doe@android.com"
        )
    }
}

@Composable
fun ContactInfoItem(iconId: Int, infoText: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 10.dp)
        )
        Text(text = infoText)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardAppScreen()
    }
}