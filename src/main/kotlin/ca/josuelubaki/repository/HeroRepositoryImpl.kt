package ca.josuelubaki.repository

import ca.josuelubaki.models.ApiResponse
import ca.josuelubaki.models.Hero

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */
class HeroRepositoryImpl : HeroRepository {
    override val heroes: Map<Int, List<Hero>>
        get() = TODO("Not yet implemented")

    override val page1: List<Hero>
        get() = TODO("Not yet implemented")

    override val page2: List<Hero>
        get() = TODO("Not yet implemented")

    override val page3: List<Hero>
        get() = TODO("Not yet implemented")

    override val page4: List<Hero>
        get() = TODO("Not yet implemented")

    override val page5: List<Hero>
        get() = TODO("Not yet implemented")

    override suspend fun getHeroes(page: Int): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        TODO("Not yet implemented")
    }

}