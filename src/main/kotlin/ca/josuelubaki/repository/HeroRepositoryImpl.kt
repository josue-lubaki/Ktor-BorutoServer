package ca.josuelubaki.repository

import ca.josuelubaki.data.*
import ca.josuelubaki.models.ApiResponse
import ca.josuelubaki.models.Hero
import io.ktor.http.*

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */

const val NEXT_PAGE_KEY = "nextPage"
const val PREV_PAGE_KEY = "prevPage"

class HeroRepositoryImpl : HeroRepository {
    override val heroes: Map<Int, List<Hero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }

    override val page1: List<Hero> = page1Mock

    override val page2: List<Hero> = page2Mock

    override val page3: List<Hero> = page3Mock

    override val page4: List<Hero> = page4Mock

    override val page5: List<Hero> = page5Mock

    override suspend fun getHeroes(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = HttpStatusCode.OK.description,
            prevPage = calculatePage(page)[PREV_PAGE_KEY],
            nextPage = calculatePage(page)[NEXT_PAGE_KEY],
            heroes = heroes[page]!!
        )
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        val prevPage : Int? = if (page == 1) null else page - 1
        val nextPage : Int? = if (page == 5) null else page + 1

        return mapOf(
            PREV_PAGE_KEY to prevPage,
            NEXT_PAGE_KEY to nextPage
        )
    }

    override suspend fun searchHeroes(name: String?): ApiResponse {

        return ApiResponse(
            success = true,
            message = HttpStatusCode.OK.description,
            heroes = findHeroes(name)
        )
    }

    private fun findHeroes(name: String?): List<Hero> {
        if(name.isNullOrBlank()) return emptyList()
        return heroes.values.flatten().filter { it.name.contains(name, true) }
    }

}