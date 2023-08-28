package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amphibiansapp.R


@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState ,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is AmphibiansUiState.Success -> SuccessScreen()
        is AmphibiansUiState.Error -> ErrorScreen(retryAction ,modifier = Modifier.fillMaxSize())
    }

}

@Composable
fun ErrorScreen(retryAction: () -> Unit ,modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_connection_error),
        contentDescription = ""
    )
    Text(
        text = stringResource(R.string.loading_failed),
        modifier = Modifier.padding(16.dp)
    )
    Button(onClick = retryAction) {
        Text(text = stringResource(R.string.retry) )
    }
}

@Composable
fun SuccessScreen(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.success_text)
    )
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier.size(200.dp),
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = stringResource(id = R.string.loading)
    )

}