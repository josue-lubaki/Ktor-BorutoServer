package ca.josuelubaki.plugins

import ca.josuelubaki.routes.getAllHeroes
import ca.josuelubaki.routes.root
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        root()
        getAllHeroes()
    }
}
