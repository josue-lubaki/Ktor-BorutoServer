package ca.josuelubaki.plugins

import ca.josuelubaki.routes.getAllHeroes
import ca.josuelubaki.routes.root
import ca.josuelubaki.routes.searchHeroes
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        root()
        getAllHeroes()
        searchHeroes()

        static("/images") {
            resources("images")
        }
    }
}
