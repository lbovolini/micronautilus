package com.github.lbovolini.micronautilus.findsummoner

import io.micronaut.data.model.query.builder.sql.Dialect.POSTGRES
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.r2dbc.repository.ReactorCrudRepository
import reactor.core.publisher.Mono

@R2dbcRepository(dialect = POSTGRES)
interface SummonerRepository : ReactorCrudRepository<Summoner, Long> {

    fun findByNameIgnoreCase(name: String): Mono<Summoner>
}