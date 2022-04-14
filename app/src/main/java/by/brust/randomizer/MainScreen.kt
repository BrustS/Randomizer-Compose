package by.brust.randomizer

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(navController: NavController) {
    var rangeFrom by remember { mutableStateOf("") }
    var rangeTo by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Previous number: $screenNumber",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.size(128.dp))

        OutlinedTextField(
            value = rangeFrom, onValueChange = {
                rangeFrom = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Enter range From") },
            singleLine = true,
            textStyle = TextStyle(fontSize = 32.sp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        OutlinedTextField(
            value = rangeTo, onValueChange = {
                rangeTo = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Enter range To") },
            singleLine = true,
            textStyle = TextStyle(fontSize = 32.sp)
        )
        Spacer(modifier = Modifier.size(32.dp))

        Button(onClick = {
            generateNumber(navController, rangeFrom, rangeTo, context)
        }) {
            Text(
                text = "Generate",
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
            )
        }

    }
}

fun generateNumber(
    navController: NavController,
    minRange: String,
    maxRange: String,
    context: Context
) {
    var min = 0
    var max = 0
    try {
        min = minRange.toInt()
        max = maxRange.toInt()
        if (min > max) {
            throw IllegalArgumentException("Range-From more than range-To")
        }
        screenNumber = (min..max).random().toString()
        navController.navigate("info")
    } catch (e: java.lang.Exception) {
        Toast.makeText(context, "Error! ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

@Composable
@Preview
fun PreviewMainScreen() {
    MainScreen(rememberNavController())
}