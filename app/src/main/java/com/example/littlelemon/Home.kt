package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.LittleLemonColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController, database: AppDatabase) {
    val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    val categories = databaseMenuItems.map { it.category }.distinct()
    var searchPhrase by remember { mutableStateOf("") }

    val menuItems = when {
        selectedCategory != null -> databaseMenuItems.filter { it.category == selectedCategory }
        else -> databaseMenuItems
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth(0.85f)
            )

            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .clickable { navController.navigate(Profile.route) }
            )
        }

        Column(
            modifier = Modifier
                .background(LittleLemonColor.green)
                .padding(start = 12.dp, end = 12.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = LittleLemonColor.yellow
            )
            Text(
                text = stringResource(id = R.string.location),
                fontSize = 24.sp,
                color = LittleLemonColor.cloud
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.description),
                    color = LittleLemonColor.cloud,
                    modifier = Modifier
                        .padding(bottom = 28.dp, end = 20.dp)
                        .fillMaxWidth(0.6f)
                )
                Image(
                    painter = painterResource(id = R.drawable.hero),
                    contentDescription = "Hero Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(130.dp) // Set a specific height for the image
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                )
            }

            OutlinedTextField(
                value = searchPhrase,
                onValueChange = { searchPhrase = it },
                placeholder = { Text("Enter search phrase") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    disabledTextColor = Color.Transparent,
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                )
            )
        }
        Text(
            text = "ORDER FOR DELIVERY!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(top = 15.dp, start = 10.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            categories.forEach { category ->
                val isSelected = category == selectedCategory
                Button(
                    onClick = { selectedCategory = if (isSelected) null else category },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) LittleLemonColor.selectedGray else LittleLemonColor.unselectedGray
                    ),
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                ) {
                    Text(
                        text = category.capitalize(),
                        color = if (isSelected) Color.White else Color.Black
                    )
                }
            }
        }


        Divider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            thickness = 0.5.dp,
        )


        if (searchPhrase.isNotEmpty()) {
            val filteredMenuItems = menuItems.filter {
                it.title.contains(searchPhrase, ignoreCase = true)
            }
            MenuItems(filteredMenuItems)
        } else  {
            MenuItems(menuItems)
        }

    }

}
