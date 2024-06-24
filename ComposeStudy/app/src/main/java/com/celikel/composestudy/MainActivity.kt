package com.celikel.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.celikel.composestudy.ui.theme.ComposeStudyTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                val painter = painterResource(id = R.drawable.kermit)
                val description = "Kermit playin in the snow"
                val title = "Kermit playin in the snow"
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(16.dp)
                ) {
                    ImageCard(
                        painter = painter,
                        contentDescription = description,
                        title = title
                    )
                }

                /*
                Column(
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .padding(5.dp)
                        .border(5.dp, Color.Magenta)
                        .padding(15.dp)
                        .border(5.dp, Color.Blue)
                        .padding(15.dp)
                        .border(5.dp, Color.Cyan),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    //Greeting("Android")
                    Text(text = "Hello", modifier = Modifier
                        .offset(10.dp, 10.dp)
                        .padding(5.dp))
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(text = "Word")
                    Text(text = "Click", modifier = Modifier.clickable {  })
                }
                
                 */
                
            } //ComposeStudyTheme
        } // setContent
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)// Shadow elevation
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
        Column(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(5.dp)
                .border(5.dp, Color.Magenta)
                .padding(15.dp)
                .border(5.dp, Color.Blue)
                .padding(15.dp)
                .border(5.dp, Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            //Greeting("Android")
            Text(text = "Hello", modifier = Modifier
                .offset(10.dp, 10.dp)
                .padding(5.dp))
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Word")
            Text(text = "Test")
        }
    }
}