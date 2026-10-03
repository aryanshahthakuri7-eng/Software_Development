package com.example.softwaredevelopmentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwaredevelopmentapp.ui.theme.SoftwareDevelopmentAppTheme

class SecondCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoftwareDevelopmentAppTheme {
                SecondCardScreen()
            }
        }
    }
}

@Composable
fun SecondCardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00C875)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
        ) {
            // Header Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Card",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                )

                Image(
                    painter = painterResource(R.drawable.profileimage),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Card List Area
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {

                // Card 1: Dribbble (Orange Gradient)
                SecondGradientCard(
                    gradient = Brush.horizontalGradient(listOf(Color(0xFFFFB300), Color(0xFFFF8F00))),
                    title = "Dribbble",
                    subtitle = "Paidax",
                    footerText = "*********",
                )

                // Card 2: HJM (Blue Gradient)
                SecondGradientCard(
                    gradient = Brush.horizontalGradient(listOf(Color(0xFF2980B9), Color(0xFF6DD5FA))),
                    title = "HJM",
                    subtitle = "173****8838",
                    footerText = null,
                )

                // Card 3: Tom (Teal/Green Gradient)
                SecondGradientCard(
                    gradient = Brush.horizontalGradient(listOf(Color(0xFF11998E), Color(0xFF38EF7D))),
                    title = "Tom",
                    subtitle = "Room 601, Building 8, Zhongnan Century City, No.8, Taoyuan Road...",
                    footerText = "130****9920",
                )

                // Card 4: ICBC (Purple Gradient)
                SecondGradientCard(
                    gradient = Brush.horizontalGradient(listOf(Color(0xFF654EA3), Color(0xFFEAAFC8))),
                    title = "1882 **** **** 8695",
                    subtitle = "ICBC",
                    footerText = "Debit Card                                    12/19",
                )

                // Card 5: Young (Brown/Red Gradient)
                SecondGradientCard(
                    gradient = Brush.horizontalGradient(listOf(Color(0xFF8E44AD), Color(0xFFC0392B))),
                    title = "Young",
                    subtitle = "This is the story of me and them, very...",
                    footerText = null,
                )

                // Card 6: Address Card (Blue Gradient)
                SecondGradientCard(
                    gradient = Brush.horizontalGradient(listOf(Color(0xFF3498DB), Color(0xFF2980B9))),
                    title = "",
                    subtitle = "Jinjun street, golden chrysanthemum Road, Haizhuqu District...",
                    footerText = null,
                )

                Spacer(modifier = Modifier.height(80.dp))
            }
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = {},
            containerColor = Color(0xFF00C875),
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
        ) {
            Text(
                text = "+",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun SecondGradientCard(
    gradient: Brush,
    title: String,
    subtitle: String,
    footerText: String?,
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    if (title.isNotEmpty()) {
                        Text(
                            text = title,
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                    Text(
                        text = subtitle,
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 12.sp,
                        maxLines = 2,
                    )
                }

                footerText?.let {
                    Text(
                        text = it,
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondCardScreenPreview() {
    SoftwareDevelopmentAppTheme {
        SecondCardScreen()
    }
}
