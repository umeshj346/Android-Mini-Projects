package com.example.businesscard.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.R
import com.example.businesscard.ui.theme.BusinessCardTheme

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        PersonalInfo(modifier = Modifier.align(Alignment.Center))
        CompleteContactInfo(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun PersonalInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(color = Color(0xFF263b43))
        ){
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop,
            )
        }
        Text(
            text = "Umesh Jain",
            fontSize = 40.sp,
        )
        Text(
            text = "Android Developer [Learner]",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun SingleContactInfo(
    contactIcon: ImageVector,
    @StringRes contactInfo: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
       Icon(
           imageVector = contactIcon,
           contentDescription = "Contact Number",
           modifier = Modifier.padding(8.dp),
           tint = Color(0xFF3ddc84)
       )
       Text(
           text  = stringResource(contactInfo)
       )
    }
}

@Composable
fun CompleteContactInfo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth().padding(24.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        Column{
            SingleContactInfo(Icons.Default.Phone, R.string.phone_number)
            SingleContactInfo(Icons.Default.Share, R.string.androiddev)
            SingleContactInfo(Icons.Default.Email, R.string.jainu346_gmail_com)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CompleteContactInfoPreview() {
    BusinessCardTheme {
        CompleteContactInfo()
    }
}

@Preview(showBackground = true)
@Composable
fun SingleContactInfoPreview() {
    BusinessCardTheme {
        SingleContactInfo(Icons.Default.Phone, R.string.phone_number)
    }
}

@Preview(showBackground = true)
@Composable
fun PersonalInfoPreview() {
    BusinessCardTheme {
        PersonalInfo()
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(color = Color(0x703ddc84)) {
            BusinessCard()
        }
    }
}