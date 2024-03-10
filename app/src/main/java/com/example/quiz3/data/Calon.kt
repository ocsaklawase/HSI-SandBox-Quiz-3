package com.example.quiz3.data

import androidx.annotation.StringRes
import com.example.quiz3.R

data class Calon(
    @StringRes val nama: Int,
    @StringRes val nip: Int,
    val usia: Int,
    @StringRes val kota: Int
)

val DaftarCalon = listOf(
    Calon(R.string.nama1, R.string.nip1, 18, R.string.kota1),
    Calon(R.string.nama2, R.string.nip2, 21, R.string.kota2),
    Calon(R.string.nama3, R.string.nip3, 19, R.string.kota3),
    Calon(R.string.nama4, R.string.nip4, 25, R.string.kota4),
    Calon(R.string.nama5, R.string.nip5, 18, R.string.kota5),
    Calon(R.string.nama6, R.string.nip6, 21, R.string.kota6),
    Calon(R.string.nama7, R.string.nip7, 19, R.string.kota7),
    Calon(R.string.nama8, R.string.nip8, 25, R.string.kota8)
)
