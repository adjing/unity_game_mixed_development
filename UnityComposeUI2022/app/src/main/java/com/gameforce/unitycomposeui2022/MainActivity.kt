package com.gameforce.unitycomposeui2022


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import com.game.datatransfer.Database

import com.gameforce.unitycomposeui2022.ui.theme.UnityComposeUI2022Theme
import com.unity3d.player.UnityPlayerActivity

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


class MainActivity : ComponentActivity() {
    var m_content: MainActivity=this

    private val intentResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        println("Unity 启动完成1")
        if (result.resultCode == RESULT_OK) {
            println("Unity 启动完成")
            val intent = result.data
            // Handle the Intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InitGame(m_content);
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                /* creating route "home" */
                composable(route = "home") {
                    /* Using composable function */
                    HomeScreen(navController)
                }
                composable(
                    route = "second/{content}",
                    arguments = listOf(
                        navArgument("content") {
                            /* configuring arguments for navigation */
                            type = NavType.StringType
                        }
                    )
                ) {
                    SecondScreen(
                        navController,
                        it.arguments?.getString("content")
                    )
                }
            }
//            UnityComposeUI2022Theme {
//                val expanded = remember { mutableStateOf(false) }
//
//                val extraPadding = if (expanded.value) 48.dp else 0.dp
//
//                Surface(
//                    color = MaterialTheme.colorScheme.primary,
//                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//                ) {
//                    Column() {
//                        Row(modifier = Modifier.padding(24.dp)) {
//                            Column(
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .padding(bottom = extraPadding)
//                            ) {
//                                Text(text = "Hello, ")
//                                Text(text = "Game")
//                            }
//                            ElevatedButton(
//                                onClick = {
//                                    var message = "abc";
//                                    val intent =
//                                        Intent(m_content, UnityPlayerActivity::class.java).apply {
//                                            putExtra(EXTRA_MESSAGE, message)
//                                        }
////                                  startActivity(intent)
//                                    intentResultLauncher.launch(intent)
//                                    //
//                                    expanded.value = !expanded.value
//                                }
//                            ) {
//                                Text(if (expanded.value) "Show less" else "Show more")
//                            }
//                        }
//                        Row(modifier = Modifier.padding(24.dp)) {
//                            Column(
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .padding(bottom = extraPadding)
//                            ) {
//                                Text(text = "Data, ")
//                                Text(text = "2")
//                            }
//                            ElevatedButton(
//                                onClick = {
//                                    var dbrow = Database.GetInfo()
//                                    println(dbrow)
//                                }
//                            ) {
//                                Text(if (expanded.value) "Show less" else "Show more")
//                            }
//                        }
//                    }//column
//                }
//            }
        }//setContent end
    }

    private fun InitGame(mContent: MainActivity) {
        Database.InsertDefault()
    }

    @Composable
    fun HomeScreen(navController: NavController) {

        ElevatedButton(
                                onClick = {
                                    var message = "abc";
                                    /* going to second screen with the value of text */
                                    navController.navigate("second/$message")
                                }
                            ) {
                                Text("Show less")
                            }


    }

    @Composable
    fun SecondScreen(navController: NavController, content: String?) {
        require(content != null)


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            ElevatedButton(
                onClick = {
                    var message = "abc";
                    /* going back to the main screen */
                    navController.navigateUp()
                }
            ) {
                Text("Show")
            }
        }
    }
}
//
//@Composable
//private fun Greeting(name: String) {
//
//    val expanded = remember { mutableStateOf(false) }
//
//    val extraPadding = if (expanded.value) 48.dp else 0.dp
//
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(modifier = Modifier
//                .weight(1f)
//                .padding(bottom = extraPadding)
//            ) {
//                Text(text = "Hello, ")
//                Text(text = name)
//            }
//            ElevatedButton(
//                onClick = {
//                    //open unity
//                    var bo= MainActivity();
//                    bo.OpenUnity()
//                    expanded.value = !expanded.value
//                }
//            ) {
//                Text(if (expanded.value) "Show less" else "Show more")
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnityComposeUI2022Theme {

    }
}

//https://www.kotlincn.net/docs/reference/exceptions.html

//java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String android.content.Context.getPackageName()' on a null object reference