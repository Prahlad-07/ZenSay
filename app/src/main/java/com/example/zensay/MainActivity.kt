package com.example.zensay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zensay.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load the data asynchronously
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)  // Small delay to simulate loading
            DataManager.LoadAssetFromFile(applicationContext)  // Loading data from asset
        }

        setContent {
            App()  // Set content for the app
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        // Display the quote list screen if data is loaded
        QuoteListScreen(DataManager.data) { }
    } else {
        // Show reloading screen while the data is loading
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            ReloadingScreen()  // Show the reloading screen
        }
    }
}

@Composable
fun ReloadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Stylish Circular Progress Indicator with animation
            CircularProgressIndicator(
                modifier = Modifier
                    .size(80.dp)  // Spinner size
                    .padding(16.dp),
                color = MaterialTheme.colorScheme.primary,  // Customize the spinner color
                strokeWidth = 6.dp // Customize the stroke width of the spinner
            )

            Spacer(modifier = Modifier.height(24.dp)) // Increased space between spinner and text

            // Stylish text to indicate loading
            Text(
                text = "Loading quotes...",
                style = MaterialTheme.typography.headlineSmall, // More prominent text style
                color = Color.Gray, // You can also change the text color
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}
