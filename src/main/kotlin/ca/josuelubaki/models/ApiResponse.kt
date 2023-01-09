package ca.josuelubaki.models

import ca.josuelubaki.models.Hero
import kotlinx.serialization.Serializable

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList(),
)
