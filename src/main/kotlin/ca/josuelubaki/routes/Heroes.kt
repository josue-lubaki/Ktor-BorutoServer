package ca.josuelubaki.routes

import ca.josuelubaki.models.ApiResponse
import ca.josuelubaki.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */

fun Route.getAllHeroes() {
    get("/boruto/heroes") {
       try {
           val page = call.request.queryParameters["page"]?.toInt() ?: 1
           require(page in 1..5)

           call.respond(message = page, status = HttpStatusCode.OK)
       }
       catch (e: NumberFormatException) {
           call.respond(
               message = ApiResponse(success = false, message = "Invalid page number"),
               status = HttpStatusCode.BadRequest
           )
       }
       catch (e: IllegalArgumentException) {
           call.respond(
               message = ApiResponse(success = false, message = "Heroes not found"),
               status = HttpStatusCode.BadRequest
           )
       }
    }
}