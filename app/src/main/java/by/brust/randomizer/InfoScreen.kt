package by.brust.randomizer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun InfoScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Result:",
            fontSize = 42.sp
        )
        Spacer(modifier = Modifier.size(48.dp))
        Text(
            text = screenNumber,
            fontSize = 88.sp
        )
        Spacer(modifier = Modifier.size(64.dp))

        Button(onClick = {
            navController.navigate("main")
        }) {
            Text(text = "Back")
        }
    }
}

@Composable
@Preview
fun PreviewInfoScreen() {
    InfoScreen(navController = rememberNavController())
}
