package com.github.lbovolini.micronautilus.findsummoner

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.filter.HttpClientFilter
import org.reactivestreams.Publisher

@Filter(serviceId = ["\${riot-api.url}"])
internal class RiotAPIFilter(private val riotAPI: RiotAPIConfiguration) : HttpClientFilter {

    override fun doFilter(request: MutableHttpRequest<*>, chain: ClientFilterChain): Publisher<out HttpResponse<*>> {

        request.headers {
            it.add("X-Riot-Token", riotAPI.token)
        }

        return chain.proceed(request)
    }
}