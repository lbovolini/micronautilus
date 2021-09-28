package com.github.lbovolini.micronautilus

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.github.lbovolini.micronautilus")
		.start()
}

