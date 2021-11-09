package de.aditu.buchschrank.controller

import de.aditu.buchschrank.client.GpsClient
import de.aditu.buchschrank.client.GpsResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController {

    @GetMapping
    fun info(): String = "1.1"

}