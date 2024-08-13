package com.example.learningflagsapp.data

import android.content.Context
import com.example.learningflagsapp.R
import com.neovisionaries.i18n.CountryCode

data class Flag(
    val countryName: String,
    val countryCode: String, // Le code ISO 3166-1 alpha-2
    val resId: Int // L'identifiant de la ressource drawable
)

// Fonction pour charger tous les drapeaux automatiquement
fun getFlags(context: Context): List<Flag> {
    val codes = context.resources.getStringArray(R.array.country_codes)
    return codes.map { code ->
        val resId = context.resources.getIdentifier(code, "drawable", context.packageName)
        Flag(getCountryNameFromCode(code.replace("flag_","")), code, resId)
    }
}

fun getCountryNameFromCode(code: String): String {
    val country = CountryCode.getByAlpha2Code(code.uppercase())
    return country?.getName() ?: "Unknown"
}