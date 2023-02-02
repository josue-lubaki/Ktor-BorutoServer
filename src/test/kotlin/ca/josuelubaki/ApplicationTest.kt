package ca.josuelubaki

import ca.josuelubaki.data.*
import ca.josuelubaki.models.ApiResponse
import ca.josuelubaki.models.Hero
import ca.josuelubaki.plugins.configureStatusPages
import ca.josuelubaki.repository.HeroRepository
import ca.josuelubaki.repository.NEXT_PAGE_KEY
import ca.josuelubaki.repository.PREV_PAGE_KEY
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.testing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.experimental.categories.Categories.CategoryFilter.exclude
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    private val heroRepository: HeroRepository by inject(HeroRepository::class.java)

    @Test
    fun `access root endpoint, assert correct information`() = testApplication {
        client.get("/").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )
            assertEquals(
                expected = "Welcome to the Boruto API",
                actual = body()
            )
        }
    }

    @Test
    fun `access all heroes, assert correct informations`() = testApplication {

        environment {
            developmentMode = false
        }

        client.get("/boruto/heroes").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actual = Json.decodeFromString<ApiResponse>(body())

            val expected = ApiResponse(
                success = true,
                message = HttpStatusCode.OK.description,
                prevPage = null,
                nextPage = 2,
                heroes = heroRepository.page1,
                lastUpdated = actual.lastUpdated
            )

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `access all heroes, query second page, assert correct informations`() = testApplication {

        environment {
            developmentMode = false
        }

        client.get("/boruto/heroes?page=2").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actual = Json.decodeFromString<ApiResponse>(body())

            val expected = ApiResponse(
                success = true,
                message = HttpStatusCode.OK.description,
                prevPage = 1,
                nextPage = 3,
                heroes = heroRepository.page2,
                lastUpdated = actual.lastUpdated
            )

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `access all heroes, query non existing page number, assert error`() = testApplication {

        environment {
            developmentMode = false
        }

        client.get("/boruto/heroes?page=6").apply {
            assertEquals(
                expected = HttpStatusCode.NotFound,
                actual = status
            )

            val expected = ApiResponse(
                success = false,
                message = "Heroes not found",
            )

            val actual = Json.decodeFromString<ApiResponse>(body())

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `access all heroes, query invalid page number, assert error`() = testApplication {

        environment {
            developmentMode = false
        }

        client.get("/boruto/heroes?page=test").apply {
            assertEquals(
                expected = HttpStatusCode.BadRequest,
                actual = status
            )

            val expected = ApiResponse(
                success = false,
                message = "Invalid page number",
            )

            val actual = Json.decodeFromString<ApiResponse>(body())

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `access all heroes, query all pages, assert correct informations`() = testApplication {

        environment {
            developmentMode = false
        }

        val pages = 1..5
        val heroes = listOf(
            page1Mock,
            page2Mock,
            page3Mock,
            page4Mock,
            page5Mock
        )

        pages.forEach{ page ->
            client.get("/boruto/heroes?page=$page").apply {
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = status
                )

                val actual = Json.decodeFromString<ApiResponse>(body())

                val expected = ApiResponse(
                    success = true,
                    message = HttpStatusCode.OK.description,
                    prevPage = calculatePage(page)[PREV_PAGE_KEY],
                    nextPage = calculatePage(page)[NEXT_PAGE_KEY],
                    heroes = heroes[page - 1],
                    lastUpdated = actual.lastUpdated
                )

                assertEquals(expected, actual)
            }
        }
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        val prevPage : Int? = if (page == 1) null else page - 1
        val nextPage : Int? = if (page == 5) null else page + 1

        return mapOf(
            PREV_PAGE_KEY to prevPage,
            NEXT_PAGE_KEY to nextPage
        )
    }

    @Test
    fun `access search heroes endpoint, query an empty text, assert empty list as a result`() = testApplication {

        environment {
            developmentMode = false
        }

        client.get("/boruto/heroes/search?name=").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actual = Json.decodeFromString<ApiResponse>(body()).heroes

            assertEquals (
                expected = emptyList(),
                actual = actual
            )
        }
    }

    @Test
    fun `access search heroes endpoint, query non existing hero, assert empty list as a result`() = testApplication {

        environment {
            developmentMode = false
        }

        client.get("/boruto/heroes/search?name=unknown").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actual = Json.decodeFromString<ApiResponse>(body()).heroes

            assertEquals (
                expected = emptyList(),
                actual = actual
            )
        }
    }

    @Test
    fun `access search heroes endpoint, query search with hero name, assert single hero result`() = testApplication {

        environment {
            developmentMode = false
        }

        client.get("/boruto/heroes/search?name=sas").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actual = Json.decodeFromString<ApiResponse>(body()).heroes.size

            assertEquals(
                expected = 1,
                actual = actual
            )
        }
    }

    @Test
    fun `access search heroes endpoint, query search with hero name, assert multiple heroes result`() = testApplication {

        environment {
            developmentMode = false
        }

        client.get("/boruto/heroes/search?name=sa").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actual = Json.decodeFromString<ApiResponse>(body()).heroes.size

            assertEquals(
                expected = 3,
                actual = actual
            )
        }
    }

    @Test
    fun `access non existing endpoint, assert not found`() = testApplication {

        environment {
            developmentMode = false
        }

        application {
            configureStatusPages()
        }

        client.get("/unknown").apply {
            assertEquals(
                expected = HttpStatusCode.NotFound,
                actual = status
            )

            assertEquals (
                expected = "Page not found",
                actual = body()
            )
        }
    }
}