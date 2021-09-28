package com.github.lbovolini.micronautilus.findsummoner

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.validation.Validated
import org.reactivestreams.Publisher
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

@Validated
@Controller("/api/summoners")
class FindSummonerResource(
    private val findSummonerClient: FindSummonerClient,
    private val summonerRepository: SummonerRepository
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Get("/{name}")
    fun findByName(@PathVariable name: String): Publisher<HttpResponse<SummonerResponse>> {
        return summonerRepository.findByNameIgnoreCase(name)
            .switchIfEmpty(findRiotSummoner(name))
            .map(::SummonerResponse)
            .map(::ok)
    }

    private fun findRiotSummoner(name: String): Mono<Summoner> {
        return findSummonerClient.findByName(name)
            .map {
                log.info("Calling Riot API for summoner={}", name)
                it.toSummoner()
            }
            .flatMap { summonerRepository.save(it) }
    }

}