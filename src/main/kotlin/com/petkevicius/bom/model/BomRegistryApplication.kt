package com.petkevicius.bom.model

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BomRegistryApplication

fun main(args: Array<String>) {
	runApplication<BomRegistryApplication>(*args)
}
