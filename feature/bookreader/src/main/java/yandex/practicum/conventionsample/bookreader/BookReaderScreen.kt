package yandex.practicum.conventionsample.bookreader

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
fun BookReaderScreen() {
    LaunchedEffect(AnalyticsManager) {
        AnalyticsManager.logScreenEnter("bookReader")
    }

    Card(modifier = Modifier.fillMaxWidth().fillMaxHeight(fraction = .3f)) {
        Text("Экран читалки", style = MaterialTheme.typography.headlineSmall)
    }
}