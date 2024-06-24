package com.celikel.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.celikel.composestudy.ui.theme.ComposeStudyTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
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