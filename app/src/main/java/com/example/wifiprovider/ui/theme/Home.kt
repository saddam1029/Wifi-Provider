package com.example.wifiprovider.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wifiprovider.R
import com.example.wifiprovider.ui.theme.WifiProviderTheme

@Composable
fun HomeScreen() {
    var isWifiEnabled by remember { mutableStateOf(false) }
    var isDataEnabled by remember { mutableStateOf(true) }
    var isHotspotEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Wi-Fi ",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF007BFF)
            )
            Text(
                text = "Manager",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_setting),
                contentDescription = "Settings",
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Toggle Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Wifi Card
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF2F6FF)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_wifi),
                        contentDescription = null,
                        tint = Color(0xFF666666),
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "Wifi",
                        color = Color(0xFF666666),
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Switch(
                        checked = isWifiEnabled,
                        onCheckedChange = { isWifiEnabled = it },
                        modifier = Modifier.scale(0.75f),
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color(0xFFB0B0B0),
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Color(0xFFD1D1D1),
                            uncheckedBorderColor = Color.Transparent
                        )
                    )
                }
            }

            // Data Card
            val dataBrush = Brush.linearGradient(
                colors = listOf(Color(0xFF20A9FF), Color(0xFF0066FF))
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(dataBrush)
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_data),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Data", color = Color.White, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.weight(1f))
                    Switch(
                        checked = isDataEnabled,
                        onCheckedChange = { isDataEnabled = it },
                        modifier = Modifier.scale(0.75f),
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFF007BFF),
                            checkedTrackColor = Color.White,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Color(0x66FFFFFF),
                            uncheckedBorderColor = Color.Transparent
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Central Hotspot Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { isHotspotEnabled = !isHotspotEnabled },
                modifier = Modifier.size(120.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isHotspotEnabled) R.drawable.ic_hotspot_on else R.drawable.ic_hotspot_off
                    ),
                    contentDescription = "Toggle Hotspot",
                    tint = Color.Unspecified,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tap to turn on Hotspot",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Surface(
                color = Color(0xFFEFF4FF),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "No Device Connected",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = Color(0xFF007BFF),
                    fontSize = 11.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Grid Section
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                FeatureCard(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_timer,
                    title = "Timer",
                    subtitle = "Auto-turn off",
                    value = "1h 20m",
                    containerColor = Color(0xFFF9EFFF)
                )
                FeatureCard(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_battery_limit,
                    title = "Battery Limit",
                    subtitle = "Stop When low",
                    value = "20%",
                    containerColor = Color(0xFFEFF4FF)
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                FeatureCard(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_data_limit,
                    title = "Data Limit",
                    subtitle = "Usage tracking",
                    value = "2.0 GB",
                    containerColor = Color(0xFFFFF6EF)
                )
                FeatureCard(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_temperature_limit,
                    title = "Temperature Limit",
                    subtitle = "Stop When exceeds",
                    value = "40° C",
                    containerColor = Color(0xFFFFEFEF)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(80.dp)) // Extra space for bottom nav
    }
}

@Composable
fun FeatureCard(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    subtitle: String,
    value: String,
    containerColor: Color
) {
    Card(
        modifier = modifier.height(140.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(45.dp)
                )
                Text(
                    text = value,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    WifiProviderTheme {
        HomeScreen()
    }
}
