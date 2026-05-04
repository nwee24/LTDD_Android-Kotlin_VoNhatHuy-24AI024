package com.example.lab2_business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2_business_card.ui.theme.Lab2_Business_CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2_Business_CardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF1B4332), Color(0xFF2A6041))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundGradient),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(170.dp)
                    .shadow(15.dp, CircleShape)
                    .clip(CircleShape)
                    .background(Color(0xFF073042))
                    .border(4.dp, Color(0xFF8EF9FF), CircleShape)
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "VÕ NHẬT HUY",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                letterSpacing = 2.sp
            )

            Text(
                text = "MÃ SINH VIÊN: 24AI024",
                color = Color(0xFF8EF9FF),
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Card(
            modifier = Modifier
                .padding(bottom = 60.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(0.85f),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.1f)), // Nền mờ (Glassmorphism)
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                ContactInfo(icon = Icons.Default.Phone, text = "0392749458")
                Divider(color = Color.White.copy(alpha = 0.2f), thickness = 0.5.dp, modifier = Modifier.padding(vertical = 4.dp))
                ContactInfo(icon = Icons.Default.Share, text = "VKU")
                Divider(color = Color.White.copy(alpha = 0.2f), thickness = 0.5.dp, modifier = Modifier.padding(vertical = 4.dp))
                ContactInfo(icon = Icons.Default.Email, text = "huyvn.24ai@vku.udn.vn")
            }
        }
    }
}

@Composable
fun ContactInfo(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF8EF9FF),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Normal
        )
    }
}