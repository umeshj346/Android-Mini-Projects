package com.example.lemonade.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.R
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

@Composable
fun HomeScreen() {
    val imageArray = arrayOf(R.drawable.lemon_tree, R.drawable.lemon_squeeze, R.drawable.lemon_drink, R.drawable.lemon_restart)
    var reqTapCount by remember { mutableIntStateOf(1) }
    var actTapCount by remember { mutableIntStateOf(0) }
    var imageIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = { TopAppBar() }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            ImageButton(
                onClick = {
                    actTapCount++
                    if (actTapCount == reqTapCount) {
                        imageIndex = (imageIndex + 1)%4
                        actTapCount = 0
                        reqTapCount = if (imageIndex != 1) 1 else Random.nextInt(2, 5)
                    }
                },
                imageId = imageArray[imageIndex]
            )
        }

    }
}

@Composable
fun ImageButton(
    onClick: () -> Unit,
    imageId: Int,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .clip(RoundedCornerShape(32.dp))
            .background(color = Color(0xFFA5FFBC)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(32.dp)
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Lemonade",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFFFFE100)
        )
    )

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LemonadeTheme {
        HomeScreen()
    }
}