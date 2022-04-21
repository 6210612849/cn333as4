package com.example.unitconverter.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.unitconverter.R

sealed class Screen(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int
) {
    companion object {
        val screens = listOf(Temperature, Distances,Mass,Pressure)
    }

    private object Temperature: Screen(
        "temperature",
        R.string.temperature,
        R.drawable.outline_thermostat_24,

    )

    private object Distances: Screen(
        "distances",
        R.string.distances,
        R.drawable.outline_square_foot_24
    )
    private object Mass: Screen("mass",
        R.string.mass,
        R.drawable.baseline_scale_24
    )
    private object Pressure: Screen("pressure",
        R.string.pressure,
        R.drawable.baseline_cloud_sync_24
    )
}
