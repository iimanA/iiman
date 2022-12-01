package com.example.assign1.ui
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.assign1.R
import com.example.assign1.models.ForecastConditions
import com.example.assign1.models.ForecastConditionsData


@Composable
fun ForecastConditions(
    viewModel: ForecastViewModel = hiltViewModel(),
) {
    val state by viewModel.forecastConditions.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }
    state?.let {
        ForecastContent(it)

    }
}


@Composable
private fun ForecastContent(
    forecastConditions: ForecastConditions,
){
    LazyColumn {
        items(items = forecastConditions.forecastData)  { item: ForecastConditionsData ->
            ForecastRow(item = item)
        }
    }
}

@Composable
private fun ForecastRow(item: ForecastConditionsData) = Row(
    modifier = Modifier
        .background(Color.White)
        .padding(8.dp),
    verticalAlignment = Alignment.CenterVertically,
) {
    val textStyle = TextStyle(
        fontSize = 18.sp,
    )
    AsyncImage(
        model = String.format("https://openweathermap.org/img/wn/%s@2x.png",
            item.weatherData.firstOrNull()?.iconName),
        contentDescription = "")


    Spacer(modifier = Modifier.weight(1f, fill = true))
    Text(
        text = stringResource(id = R.string.date, item.date),
        style = textStyle,
    )

    Spacer(modifier = Modifier.weight(1f, fill = true))
    Column {
        Text(
            text = stringResource(id = R.string.high, item.forecastTemp.dailyMax.toInt()),
            style = textStyle,
        )
        Text(
            text = stringResource(id = R.string.low, item.forecastTemp.dailyMin.toInt()),
            style = textStyle,

        )
    }
    Spacer(modifier = Modifier.weight(1f, fill = true))
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = stringResource(
                id = R.string.sunrise, item.dailySunset,

            ),
            style = textStyle,
        )
        Text(text = stringResource( id = R.string.sunset, item.dailySunset,  ), style = textStyle, )
    }
}

@Preview
    (
    showSystemUi = true
)
@Composable
private fun ForecastScreenPreview() {
    ForecastConditions()
}







