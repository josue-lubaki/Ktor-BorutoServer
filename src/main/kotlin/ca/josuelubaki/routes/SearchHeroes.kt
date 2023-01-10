package ca.josuelubaki.routes

import ca.josuelubaki.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-10
 */

fun Route.searchHeroes() {
    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes/search"){
        val name = call.request.queryParameters["name"]

        val apiResponse = heroRepository.searchHeroes(name)

        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}