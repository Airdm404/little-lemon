package com.example.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LittleLemonUserInfo", Context.MODE_PRIVATE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(120.dp))
        Text(
            text = "Personal information",
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "First name:",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "${sharedPreferences.getString("firstName", "")}",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
                    .padding(start= 100.dp)
            )
        }


        Spacer(modifier = Modifier.height(30.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Last name:",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)

            )
            Text(
                text = "${sharedPreferences.getString("lastName", "")}",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
                    .padding(start= 100.dp)
            )
        }


        Spacer(modifier = Modifier.height(30.dp))
        
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Email:",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "${sharedPreferences.getString("email", "default")}",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
                    .padding(start= 100.dp)
            )

        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {
                sharedPreferences.edit().clear().apply()
                navController.navigate(Onboarding.route)
            },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Log out")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    Profile(navController = navController)
}