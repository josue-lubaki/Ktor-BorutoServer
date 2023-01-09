package ca.josuelubaki.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */
fun Route.root() {
    get("/") {
        call.respond(
            message = "Welcome to the Boruto API",
            status = HttpStatusCode.OK
        )
    }
}