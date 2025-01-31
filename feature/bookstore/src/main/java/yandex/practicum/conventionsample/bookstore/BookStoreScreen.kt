package yandex.practicum.conventionsample.bookstore

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import yandex.practicum.conventionsample.lib.analytics.AnalyticsManager

@Composable
fun BookStoreScreen() {
    LaunchedEffect(AnalyticsManager) {
        AnalyticsManager.logScreenEnter("bookReader")
    }

    Card(modifier = Modifier.fillMaxWidth().fillMaxHeight(fraction = .3f)) {
        Text("Экран магазина", style = MaterialTheme.typography.headlineSmall)
    }
}