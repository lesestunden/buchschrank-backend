package de.aditu.buchschrank

import de.aditu.buchschrank.client.GpsAddress
import de.aditu.buchschrank.client.GpsResponse
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.nativex.hint.TypeHint

@TypeHint(types = arrayOf(GpsResponse::class, GpsAddress::class), typeNames = arrayOf("de.aditu.buchschrank.client.GpsResponse\$GpsAddress"))
@SpringBootApplication
class BuchschrankApplication

fun main(args: Array<String>) {
	runApplication<BuchschrankApplication>(*args)
}
