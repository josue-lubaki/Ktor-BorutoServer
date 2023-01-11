package ca.josuelubaki.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-10
 */

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, _ ->
            call.respond(
                message = "Page not found",
                status = HttpStatusCode.NotFound
            )
        }
    }
}