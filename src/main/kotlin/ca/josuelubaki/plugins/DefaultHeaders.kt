package ca.josuelubaki.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*
import java.time.Duration

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */

fun Application.configureDefaultHeaders() {
    install(DefaultHeaders) {
        val oneYearInSeconds = Duration.ofDays(365).seconds
        header(name = HttpHeaders.CacheControl, value = "public, max-age=$oneYearInSeconds, immutable")
    }
}