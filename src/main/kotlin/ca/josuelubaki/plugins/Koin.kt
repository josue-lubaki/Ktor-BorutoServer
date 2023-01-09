package ca.josuelubaki.plugins

import ca.josuelubaki.module
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
    }
}