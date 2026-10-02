package com.example.softwaredevelopmentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoftwareDevelopmentAppTheme {
                CardScreen()
            }
        }
    }
}

@Composable
fun CardScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00C875))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {

            // Header Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Card",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Simple and easy to use app",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 14.sp
                    )
                }

                Image(
                    painter = painterResource(R.drawable.profileimage),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tab Selector
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (selectedTab == 0) Color.White else Color.White.copy(alpha = 0.2f),
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = 0 }
                ) {
                    Box(
                        modifier = Modifier.padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Categories",
                            color = if (selectedTab == 0) Color(0xFF00C875) else Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (selectedTab == 1) Color.White else Color.White.copy(alpha = 0.2f),
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = 1 }
                ) {
                    Box(
                        modifier = Modifier.padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "My Cards",
                            color = if (selectedTab == 1) Color(0xFF00C875) else Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Content Area
            if (selectedTab == 0) {
                CategoriesGridView()
            } else {
                CardsListView()
            }
        }

        // Floating Action Button for Cards ListView
        if (selectedTab == 1) {
            FloatingActionButton(
                onClick = {},
                containerColor = Color(0xFF00C875),
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(24.dp)
            ) {
                Text(
                    text = "+",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun CategoriesGridView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Grid Rows
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CategoryCard(
                iconRes = R.drawable.ic_book,
                title = "Text",
                subtitle = "11 items content",
                modifier = Modifier.weight(1f)
            )

            CategoryCard(
                iconRes = R.drawable.ic_address,
                title = "Address",
                subtitle = "3 items content",
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CategoryCard(
                iconRes = R.drawable.ic_character,
                title = "Character",
                subtitle = "10 items content",
                modifier = Modifier.weight(1f)
            )

            CategoryCard(
                iconRes = R.drawable.ic_credit_card,
                title = "Bank card",
                subtitle = "5 items content",
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CategoryCard(
                iconRes = R.drawable.ic_key,
                title = "Password",
                subtitle = "21 items content",
                modifier = Modifier.weight(1f)
            )

            CategoryCard(
                iconRes = R.drawable.ic_package,
                title = "Logistics",
                subtitle = "13 items content",
                modifier = Modifier.weight(1f)
            )
        }

        // Settings Full Width Card
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_settings),
                    contentDescription = "Settings",
                    tint = Color(0xFF95A5A6),
                    modifier = Modifier.size(36.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Settings",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2C3E50)
                    )
                    Text(
                        text = "Fingerprint code and so on",
                        fontSize = 12.sp,
                        color = Color(0xFF95A5A6)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun CategoryCard(
    iconRes: Int,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.height(130.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(iconRes),
                contentDescription = title,
                tint = Color.Unspecified,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C3E50)
            )

            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = Color(0xFF95A5A6)
            )
        }
    }
}

@Composable
fun CardsListView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        // Dribbble Card (Orange Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFFFFA000), Color(0xFFFF6F00))),
            title = "Dribbble",
            subtitle = "Paidax",
            codeText = "**********"
        )

        // HJM Card (Blue Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFF2980B9), Color(0xFF6DD5FA))),
            title = "HJM",
            subtitle = "173****8838",
            codeText = null
        )

        // Tom Card (Green Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFF11998E), Color(0xFF38EF7D))),
            title = "Tom",
            subtitle = "Room 601, Building 8, Zhongnan Century\nCity, No.8, Taoyuan Road...",
            codeText = "530****9920"
        )

        // ICBC Card (Purple Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFF5C258D), Color(0xFF4389A2))),
            title = "1882 **** **** 8695",
            subtitle = "ICBC",
            codeText = "Debit Card                    12/19"
        )

        // Young Card (Peach/Brown Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFFD4145A), Color(0xFFFBB03B))),
            title = "Young",
            subtitle = "This is the story of me and them, very...",
            codeText = null
        )

        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
fun GradientCard(
    gradient: Brush,
    title: String,
    subtitle: String,
    codeText: String?
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = title,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = subtitle,
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 12.sp
                    )
                }

                if (codeText != null) {
                    Text(
                        text = codeText,
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardScreenPreview() {
    SoftwareDevelopmentAppTheme {
        CardScreen()
    }
}
