package com.github.lbovolini.micronautilus.findsummoner

import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import reactor.core.publisher.Mono
import javax.validation.constraints.NotBlank

@Client(id = "\${riot-api.url}", path = "/lol/summoner/v4/summoners")
interface FindSummonerClient {

    @Get("/by-name/{name}")
    @SingleResult
    @Consumes(MediaType.APPLICATION_JSON)
    fun findByName(@PathVariable @NotBlank name: String): Mono<RiotSummonerResponse>
}