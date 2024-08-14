package com.siarheikrupenich.testrepo.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.siarheikrupenich.testrepo.presentation.data.RepoUi
import com.siarheikrupenich.testrepo.presentation.ui.style.Size
import com.siarheikrupenich.testrepo.presentation.ui.style.UiConstants.Companion.COLOR_ALPHA_20

@Composable
internal fun RepositoryViewHolder(repoUi: RepoUi) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = Size.zero,
        backgroundColor = MaterialTheme.colors.primary.copy(alpha = COLOR_ALPHA_20),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Size.spacing4, horizontal = Size.spacing16)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Size.spacing16)
        ) {
            Text(
                text = repoUi.title,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onSurface,
            )
            Spacer(modifier = Modifier.height(Size.spacing4))
            Text(
                text = repoUi.description,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyColumnWithRoundedCards() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) { _ ->
            RepositoryViewHolder(
                RepoUi(0, "Test title", "tiest description")
            )
        }
    }
}
