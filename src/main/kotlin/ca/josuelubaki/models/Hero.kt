package ca.josuelubaki.models

import kotlinx.serialization.Serializable

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */

@Serializable
data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>,
)
