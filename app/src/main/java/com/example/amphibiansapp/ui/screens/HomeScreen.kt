package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.AmphibiansPhoto
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme


@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState ,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is AmphibiansUiState.Success -> AmphibianCardList(amphibiansUiState.photos, modifier = Modifier.fillMaxSize())
        is AmphibiansUiState.Error -> ErrorScreen(retryAction ,modifier = Modifier.fillMaxSize())
    }

}

@Composable
fun AmphibianCardList(photos: List<AmphibiansPhoto>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(photos, key = {photo -> photo.name}) {photo ->
            SingleAmphibianCard(
                photo = photo,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .aspectRatio(1.5f)
            )
        }
    }
}



//this displays a single amphibian entry
@Composable
fun SingleAmphibianCard(photo: AmphibiansPhoto ,modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.padding(10.dp)
            .height(460.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,

       ) {
           Text(
               text = photo.name,
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
               style = MaterialTheme.typography.titleLarge,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Start
           )


           AsyncImage(
               modifier = Modifier.fillMaxWidth(),
               model = ImageRequest.Builder(context = LocalContext.current)
                   .data(photo.imgSrc)
                   .crossfade(true)
                   .build(),
               contentDescription = stringResource(id = R.string.app_name),
               contentScale = ContentScale.FillWidth,
               error = painterResource(id = R.drawable.ic_broken_image),
               placeholder = painterResource(id = R.drawable.loading_img)
           )
           Text(
               text = photo.description,
               style = MaterialTheme.typography.titleMedium,
               textAlign = TextAlign.Justify ,
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(8.dp)
           )

           }




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

@Preview(showBackground = true)
@Composable
fun AmphibianLazyColumnPreview(){
    AmphibiansAppTheme {
        val mockData = List(10) {AmphibiansPhoto("$it", "", "", "" )}
        AmphibianCardList(mockData)
    }
}