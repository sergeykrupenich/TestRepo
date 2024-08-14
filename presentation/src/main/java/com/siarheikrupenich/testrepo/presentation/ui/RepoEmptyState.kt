package com.siarheikrupenich.testrepo.presentation.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.siarheikrupenich.testrepo.presentation.R
import com.siarheikrupenich.testrepo.presentation.ui.style.FontSize
import com.siarheikrupenich.testrepo.presentation.ui.style.Size

@Composable
internal fun RepoEmptyState(
    stateMessage: String,
    contentDescription: String,
    @DrawableRes stateImageDrawableRes: Int,
    buttonTitle: String,
    emptyButtonAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(Size.spacing16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = stateImageDrawableRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(Size.emptyStateIconSize)
        )
        Spacer(modifier = Modifier.height(Size.spacing24))
        Text(
            text = stateMessage,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
                fontSize = FontSize.emptyStateTitleSize
            ),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Size.spacing16))
        Button(onClick = { emptyButtonAction() }) {
            Text(text = buttonTitle, style = MaterialTheme.typography.caption)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewErrorState() {
    RepoEmptyState(
        stateImageDrawableRes = R.drawable.ic_error,
        stateMessage = "Preview state message",
        contentDescription = "Preview content description",
        buttonTitle = "Retry",
        emptyButtonAction = { }
    )
}
