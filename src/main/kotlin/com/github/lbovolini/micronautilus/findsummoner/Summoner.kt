package com.github.lbovolini.micronautilus.findsummoner

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.time.Instant
import javax.validation.constraints.NotBlank

@Introspected
@MappedEntity
class Summoner(
    @field:NotBlank val riotId: String,
    val riotAccountId: String,
    val riotUuid: String,
    val name: String,
    val profileIconId: Int,
    val modifiedAt: Instant,
    val level: Int
) {
    @field:Id
    @field:GeneratedValue(IDENTITY)
    var id: Long? = null
}