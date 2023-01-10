package ca.josuelubaki.di

import ca.josuelubaki.repository.HeroRepository
import ca.josuelubaki.repository.HeroRepositoryImpl
import org.koin.dsl.module

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2023-01-09
 */

val KoinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}