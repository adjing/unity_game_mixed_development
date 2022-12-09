package com.gameforce.compose_game_db_2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gameforce.compose_game_db_2023.ui.theme.Compose_game_db_2023Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        setContentView(R.layout.activity_xml_compose)
        val mLlContainer = findViewById<ComposeView>(R.id.mComposeView)
        mLlContainer.setContent {
            ComposeContent()
        }

//        setContent {
//            Compose_game_db_2023Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
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
    Compose_game_db_2023Theme {
        Greeting("Android")
    }
}

@Composable
fun ComposeContent() {
    LazyColumn(modifier = Modifier.fillMaxWidth(), content = {
        items(count = 10) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), text = "Compose List Item"
            )
        }
    })
}