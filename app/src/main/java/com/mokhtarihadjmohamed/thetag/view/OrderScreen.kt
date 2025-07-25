package com.mokhtarihadjmohamed.thetag.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.customCompose.BottomBar
import com.mokhtarihadjmohamed.thetag.customCompose.CustomGridItem
import com.mokhtarihadjmohamed.thetag.customCompose.CustomRowItem
import com.mokhtarihadjmohamed.thetag.customCompose.CustomTextField
import com.mokhtarihadjmohamed.thetag.customCompose.TopBar
import com.mokhtarihadjmohamed.thetag.model.Notification
import com.mokhtarihadjmohamed.thetag.model.Order
import com.mokhtarihadjmohamed.thetag.model.Product
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color
import com.mokhtarihadjmohamed.thetag.ui.theme.border_color

/*
* This is home screen you will find:
* 1- in the top bar that have icon off cart and chat and name category.
* 2- after that you will find search where we user customTextFiled.
* 3- after that will order list and it is in lazyColumn and every one use CustomRowItem.
* */

@Composable
fun OrderScreen(navController: NavController) {

    var text by remember { mutableStateOf("") }
    val context = LocalContext.current
    val notification = Notification("Order", "You are Order is new!")

    val menusList: List<String> =
        stringArrayResource(R.array.menus).toCollection(destination = ArrayList())

    val orders: List<Order> = arrayListOf(
        Order(
            id = "458",
            products = listOf(
                Product(
                    name = "Burger  - SM Lucena",
                    description = "Grillé à la flamme pour un goût inimitable",
                    price = 18.0,
                    imageURl = "",
                    amount = 1
                ),
                Product(
                    name = "Burger  - SM Lucena",
                    description = "Grillé à la flamme pour un goût inimitable",
                    price = 18.0,
                    imageURl = "",
                    amount = 2
                )
            ),
            date = "8 Avril 2025"
        ),
        Order(
            id = "458",
            products = listOf(
                Product(
                    name = "Burger  - SM Lucena",
                    description = "Grillé à la flamme pour un goût inimitable",
                    price = 18.0,
                    imageURl = "",
                    amount = 1
                ),
                Product(
                    name = "Burger  - SM Lucena",
                    description = "Grillé à la flamme pour un goût inimitable",
                    price = 18.0,
                    imageURl = "",
                    amount = 3
                )
            ),
            date = "8 Octobre 2024"
        ),
        Order(
            id = "458",
            products = listOf(
                Product(
                    name = "Burger  - SM Lucena",
                    description = "Grillé à la flamme pour un goût inimitable",
                    price = 18.0,
                    imageURl = "",
                    amount = 1
                ),
                Product(
                    name = "Burger  - SM Lucena",
                    description = "Grillé à la flamme pour un goût inimitable",
                    price = 18.0,
                    imageURl = "",
                    amount = 2
                )
            ),
            date = "8 Septembre 2024"
        )
    )

    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                title = "Burger King"
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxSize(),
        containerColor = background_color
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // TODO Search field
            CustomTextField(
                modifier = Modifier
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(12.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = {
                    text = it
                },
                placeholder = stringResource(R.string.search),
                icon = R.drawable.search,
                endIcon = R.drawable.fillter
            )

            // TODO list of products
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(orders) { order ->
                    CustomRowItem(
                        onClick = {
                            notification.showNotification(context)
                        },
                        order = order
                    )
                }
            }

        }
    }
}