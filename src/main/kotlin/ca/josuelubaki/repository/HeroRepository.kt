package ca.josuelubaki.repository

import ca.josuelubaki.models.ApiResponse
import ca.josuelubaki.models.Hero

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */
interface HeroRepository {

    val heroes : Map<Int, List<Hero>>

    val page1 : List<Hero>
    val page2 : List<Hero>
    val page3 : List<Hero>
    val page4 : List<Hero>
    val page5 : List<Hero>

    suspend fun getHeroes(page : Int = 1) : ApiResponse
    suspend fun searchHeroes(name : String?) : ApiResponse
}