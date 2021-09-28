package com.github.lbovolini.micronautilus.findsummoner

import io.micronaut.core.annotation.Introspected

@Introspected
class SummonerResponse(summoner: Summoner) {
    val riotId = summoner.riotId
    val riotAccountId = summoner.riotAccountId
    val riotUuid = summoner.riotUuid
    val name = summoner.name
    val profileIconId = summoner.profileIconId
    val modifiedAt = summoner.modifiedAt
    val level = summoner.level
}
