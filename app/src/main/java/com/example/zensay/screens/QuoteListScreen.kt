package com.example.zensay.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zensay.R
import com.example.zensay.models.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 24.dp)
    ) {
        Text(
            text = "Inspirational Quotes",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            modifier = Modifier.fillMaxWidth()
        )

        // ✅ Make sure `QuoteList` is correctly defined elsewhere
        QuoteList(data = data) {
            onClick()  // ✅ Correctly invoke `onClick`
        }
    }
}
