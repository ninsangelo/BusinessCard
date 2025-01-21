package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = "Nins Calope",
                        title = "Information Technology",
                        phone = "+63 966 996 7422",
                        socialMedia = "@angeloclp",
                        email = "ninin.angelo0925@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    phone: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Section: Profile Info
        ProfileInfo(name = name, title = title)

        Spacer(modifier = Modifier.weight(1f)) // Push the contact info towards the bottom

        // Bottom Section: Contact Info (centered horizontally at the bottom)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ContactInfoRow(iconResId = android.R.drawable.sym_action_call, text = phone)
            ContactInfoRow(iconResId = android.R.drawable.sym_action_chat, text = socialMedia)
            ContactInfoRow(iconResId = android.R.drawable.sym_action_email, text = email)
        }
    }
}

@Composable
fun ProfileInfo(name: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        // Profile Image (square)
        Surface(
            shape = RectangleShape, // Square shape
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            modifier = Modifier.size(150.dp) // Square size
        ) {
            Image(
                painter = painterResource(id = R.drawable.pic), // Replace "pic" with your actual image resource
                contentDescription = "Profile Picture",
                modifier = Modifier.size(150.dp) // Ensure image fits within the square
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Full Name
        Text(
            text = name,
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Title
        Text(
            text = title,
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ContactInfoRow(iconResId: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(0.7f) // Limit the width to make it visually centered
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier
                .size(34.dp)
                .padding(end = 16.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            name = "Nins Calope",
            title = "Information Technology",
            phone = "+63 966 996 7422",
            socialMedia = "@angeloclp",
            email = "ninin.angelo0925@gmail.com"
        )
    }
}
