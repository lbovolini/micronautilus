package com.github.lbovolini.micronautilus.findsummoner

import io.micronaut.context.annotation.ConfigurationProperties
import java.net.URL
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@ConfigurationProperties("riot-api")
interface RiotAPIConfiguration {

    @get:NotNull
    val url: URL

    @get:NotBlank
    val token: String
}