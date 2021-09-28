package com.github.lbovolini.micronautilus.findsummoner

import io.micronaut.core.annotation.Introspected
import java.time.Instant

@Introspected
data class RiotSummonerResponse(
    val id: String,
    val accountId: String,
    val puuid: String,
    val name: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val summonerLevel: Int
) {
    fun toSummoner(): Summoner {
        return Summoner(
            riotId = id,
            riotAccountId = accountId,
            riotUuid = puuid,
            name = name,
            profileIconId = profileIconId,
            modifiedAt = Instant.ofEpochMilli(revisionDate),
            level = summonerLevel
        )
    }
}
