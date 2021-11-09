package de.aditu.buchschrank.config

import org.springframework.context.annotation.Configuration
import java.time.ZoneId
import java.util.*
import javax.annotation.PostConstruct

@Configuration
class LocaleConfig {

    @PostConstruct
    fun configure() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Europe/Berlin")))
        Locale.setDefault(Locale.GERMAN)
    }

}