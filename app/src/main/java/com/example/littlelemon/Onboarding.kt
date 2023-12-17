package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Onboarding() {
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // replace with your image resource
            contentDescription = "Logo",
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(colorResource(id = R.color.little_lemon_green))
                .fillMaxWidth()
                .padding(25.dp),

        ) {
            Text(
                text = "Let's get to know you",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Personal information",
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "First Name",
            fontSize = 14.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = firstName.value,
            onValueChange = { firstName.value = it },
            modifier = Modifier.
            fillMaxWidth(0.95f)
                .align(Alignment.CenterHorizontally)
        )


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Last Name",
            fontSize = 14.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = lastName.value,
            onValueChange = { lastName.value = it },
            modifier = Modifier.
            fillMaxWidth(0.95f)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Email",
            fontSize = 14.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier.
            fillMaxWidth(0.95f)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(50.dp))


        Button(
            onClick = { /* TODO: Implement registration logic */ },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Register")
        }
    }

}

@Composable
fun Header() {

        Image(
            painter = painterResource(R.drawable.logo), // Replace with your asset path
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )

}
@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    Onboarding()
}