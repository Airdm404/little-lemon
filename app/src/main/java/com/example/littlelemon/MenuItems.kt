@file:OptIn(ExperimentalGlideComposeApi::class, ExperimentalGlideComposeApi::class)

package com.example.littlelemon


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun MenuItems(items: List<MenuItemRoom>) {
    LazyColumn {
        itemsIndexed(items) { _, dish ->
            Column{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column {
                        Text(
                            text = dish.title,
                            style = TextStyle(
                                color = LittleLemonColor.charcoal,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = dish.description,
                            style = TextStyle(
                                color = LittleLemonColor.green
                            ),
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp)
                                .fillMaxWidth(.75f)
                        )
                        Text(
                            text = "$${dish.price}",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = LittleLemonColor.green
                            )
                        )
                    }
                    GlideImage(model = dish.image, contentDescription = "Dish Image")
                }
                Divider(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    thickness = 0.5.dp,
                )

            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun MenuItemsPreview() {
    val id =  4
    val title = "Pasta"
    val description = "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chili, garlic, basil & salted ricotta cheese."
    val price= 10.0
    val image ="https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/pasta.jpg?raw=true"
    val category ="mains"
    val sampleMenuItems = listOf(MenuItemRoom(id, title, description, price, image, category))

    MenuItems(sampleMenuItems)
}