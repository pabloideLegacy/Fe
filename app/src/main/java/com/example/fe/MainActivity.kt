package com.example.fe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fe.ui.theme.FeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FeTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, backgroundColor: Color = Color.LightGray) {
    Surface (color=backgroundColor, modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "😤😤😤",
                    modifier = modifier
                        .padding(all = 24.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                )
            }
            Row (modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "28/08/25",
                    modifier = modifier
                        .padding(all = 24.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Los grandes objetivos no se logran con buenas intenciones, sino con acciones calculadas.",
                    modifier = Modifier.padding(vertical = 24.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 50.sp,
                    color = Color.Gray,
                )
            }

            Text(
                text = "Nicolás Maquiavelo",
                modifier = modifier
                    .padding(all = 24.dp)
                    .align(Alignment.End),
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
        }
    }
}



//@Preview(showBackground = true, widthDp = 360, heightDp = 640)
//@Composable
//fun GreetingPreview() {
//    FeTheme {
//        Greeting("Pablo")
//    }
//}

@SuppressLint("SuspiciousIndentation")
@Composable
fun BackgroundImage(modifier: Modifier = Modifier) {
    val images = painterResource(R.drawable.traveler)
        Image(
            painter = images,
            modifier = modifier.fillMaxSize(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )

        // Glassmorphism effect for the Greeting
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .graphicsLayer(alpha = 0.99f)
                .blur(
                    radiusX = 5.dp, // Adjust blur radius as needed
                    radiusY = 5.dp,
                )

        ) {
            // The content that will appear "behind" the glass
            // We draw the same image again here but it will be blurred by the parent Box
            Image(
                painter = images,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color(0x33808080), blendMode = BlendMode.SrcOver) // Slight gray tint for glass effect
            )
        }
        Greeting(name = "Pablo", backgroundColor = Color.Transparent, modifier = modifier)
    }


@Preview (showBackground = true)
@Composable
fun BackGroundImagePreview() {
    FeTheme {
        BackgroundImage()

    }
}