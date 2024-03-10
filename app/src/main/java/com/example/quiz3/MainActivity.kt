package com.example.quiz3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.rounded.FiberManualRecord
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz3.data.Calon
import com.example.quiz3.data.DaftarCalon
import com.example.quiz3.ui.theme.Quiz3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quiz3Theme {

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CalonApp()
                }
            }
        }
    }
}

@Composable
fun CalonApp() {
    Scaffold(
            topBar = {
                CalonTopAppBar()
            },
            bottomBar = {
                CalonBottomAppBar()
            },
        ) { it->
            LazyColumn(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Top,
                contentPadding = it
            ) {
                item {
                    Row(
                        modifier = Modifier.padding(bottom = 10.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.profil_berikut),
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 17.sp
                            ),
                            modifier = Modifier
                                .padding(start = 15.dp)
                        )
                    }
                }
                items(DaftarCalon) {

                    CalonItem(
                        calon = it,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                }
            }


    }
}

@Composable
fun CalonItem(
    calon: Calon,
    modifier: Modifier = Modifier
) {

    Card(modifier = modifier) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                CalonIcon(calon.nama)
                CalonInformation(calon.nama, calon.nip, calon.usia, calon.kota)
                Spacer(modifier = Modifier.weight(1f))
                CalonItemButton()
            }
    }
}

@Composable
fun CalonIcon(
    @StringRes namaCalon: Int
) {
    val firstChar = stringResource(namaCalon)
    Box(
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .padding(5.dp)
            .background(
                color = colorResource(R.color.lightPink),
                shape = RoundedCornerShape(50)
            ),
        contentAlignment = Alignment.Center


        ) {
            Text (
                text = firstChar[0].toString(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .width(50.dp)
            )
        }

}

@Composable
private fun CalonItemButton(
    modifier: Modifier = Modifier
){
    IconButton(
        modifier = modifier,
        onClick = {}
    ){
        Icon(
            imageVector = Icons.Filled.NavigateNext,
            contentDescription = stringResource(R.string.info_tombol),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}


@Composable
fun CalonInformation(
    @StringRes namaCalon: Int,
    @StringRes nip: Int,
    usiaCalon: Int,
    @StringRes kota: Int
) {
    Column(
        modifier = Modifier
            .padding(start = 15.dp),
    ) {
        Row {
            Text(
                text = stringResource(namaCalon),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = " ("+stringResource(nip)+")",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
        }
        Spacer(modifier = Modifier.padding(3.dp))
        Row {
            Text(
                text = stringResource(R.string.usia_calon, usiaCalon)
            )
            Icon(
                imageVector = Icons.Rounded.FiberManualRecord,
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .padding(5.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = stringResource(kota)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalonTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.judul),
                    style = MaterialTheme.typography.displayLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    modifier = Modifier,
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Tune,
                        contentDescription = stringResource(R.string.info_tombol),
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }

        },
        modifier = modifier
    )
}

@Composable
fun CalonBottomAppBar() {
    BottomAppBar(
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = stringResource(R.string.info_tombol),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = stringResource(R.string.home)
                )
            }
            Spacer(modifier = Modifier.padding(40.dp))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = stringResource(R.string.info_tombol),
                    tint = colorResource(R.color.bntBiru)
                )
                Text(
                    text = stringResource(R.string.pencarian),
                    style = TextStyle(colorResource(R.color.bntBiru))
                )
            }
            Spacer(modifier = Modifier.padding(40.dp))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = stringResource(R.string.info_tombol),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = stringResource(R.string.profil)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CalonAppPreview() {
    Quiz3Theme(darkTheme = false) {
        CalonApp()
    }
}