package com.example.zensay.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.zensay.models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: () -> Unit) {
    LazyColumn {
        items(data) { quote ->  // Corrected iteration over `data`
            QuoteListItems(quote= quote) {
                onClick()
            }
        }
    }
}
