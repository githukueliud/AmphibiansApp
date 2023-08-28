package com.example.amphibiansapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.amphibiansapp.R


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.loading_failed)
    )
}

@Composable
fun SuccessScreen(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.success_text)
    )
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.loading)
    )
}