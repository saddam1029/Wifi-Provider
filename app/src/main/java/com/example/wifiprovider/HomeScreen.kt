package com.example.wifiprovider

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wifiprovider.ui.screens.Home
import com.example.wifiprovider.ui.theme.WifiProviderTheme

@Composable
fun HomeScreen() {
    var isWifiEnabled by remember { mutableStateOf(false) }
    var isDataEnabled by remember { mutableStateOf(false) }
    var isHotspotEnabled by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "WI-FI",
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

            Spacer(Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.ic_setting),
                contentDescription = "Settings",
                modifier = Modifier.size(28.dp)
            )
        }

        Spacer(Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(35.dp)
        ) {

            Row(
                Modifier
                    .height(52.dp)
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        if (isWifiEnabled) Color(0xFF128CFC)
                        else Color(0xFFF2F6FF)
                    )
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_wifi),
                    contentDescription = null,
                    tint = if (isWifiEnabled) Color.White else Color(0xFF666666),
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "Wifi",
                    color = if (isWifiEnabled) Color.White else Color(0xFF666666),
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
                        checkedTrackColor = Color(0xFF57A9FD),
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color(0xFFD1D1D1),
                        uncheckedBorderColor = Color.Transparent
                    )
                )
            }

            Row(
                Modifier
                    .height(52.dp)
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        if (isDataEnabled) Color(0xFF128CFC)
                        else
                            Color(0xFFF2F6FF)
                    )
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_data),
                    contentDescription = null,
                    tint = if (isDataEnabled) Color.White else Color(0xFF666666),
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "Date",
                    color = if (isDataEnabled) Color.White else Color(0xFF666666),
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Switch(
                    checked = isDataEnabled,
                    onCheckedChange = { isDataEnabled = it },
                    modifier = Modifier.scale(0.75f),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color(0xFF57A9FD),
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color(0xFFD1D1D1),
                        uncheckedBorderColor = Color.Transparent
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        IconButton(
            onClick = { isHotspotEnabled = !isHotspotEnabled },
            modifier = Modifier.size(130.dp),
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

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = if (isHotspotEnabled) "Hotspot Active" else "Tap to turn on Hotspot",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            color = Color(0xFFEFF4FF),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = if (isHotspotEnabled)"2 Devices Connected" else "No Device Connected",
                modifier = Modifier.padding(horizontal = 13.dp, vertical = 4.dp),
                color = Color(0xFF666666),
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

       Card(
           Modifier.height(140.dp),
           shape = RoundedCornerShape(24.dp),
           colors = CardDefaults.cardColors(Color(0xFFFFF6EF))
       ) {
           Column(
               Modifier.fillMaxSize()
                   .padding(16.dp)
           ) { }
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