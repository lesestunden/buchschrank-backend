package de.aditu.buchschrank.client

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class GpsClient {

    private val client: WebClient = WebClient.builder()
        .baseUrl("https://nominatim.openstreetmap.org")
        .filter(
            ExchangeFilterFunction.ofResponseProcessor { clientResponse: ClientResponse ->
                Mono.just(
                    clientResponse.mutate()
                        .headers { it.remove(HttpHeaders.CONTENT_TYPE) }
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .build()
                )
            }
        )
        .build()

    fun reverse(lat: Double, lng: Double): GpsResult =
        client.get()
            .uri {
                it.path("reverse")
                    .queryParam("format", "jsonv2")
                    .queryParam("lat", lat)
                    .queryParam("lon", lng)
                    .queryParam("zoom", 18)
                    .queryParam("addressdetails", 1)
                    .build()
            }
            .header("User-Agent", "lesestunden.de")
            .header("Content-Type", "application/json")
            .retrieve().toEntity(GpsResponse::class.java)
            .block()?.body?.let { result ->
                GpsResult(
                    place = result?.address?.town ?:result?.address?.city ?: result?.address?.village,
                    country = result?.address?.country,
                    postcode = result?.address?.postcode,
                    streethousenumber = result?.address?.road?.let { "$it ${result?.address?.house_number ?: ""}".trim() }
                )
            }
            ?: GpsResult.empty()
}

class GpsResult(
    val place: String? = null,
    val country: String? = null,
    val postcode: String? = null,
    val streethousenumber: String? = null
) {
    companion object {
        fun empty() = GpsResult()
    }
}

class GpsResponse(
    val place_id: String? = null,
    val licence: String? = null,
    val osm_type: String? = null,
    val osm_id: String? = null,
    val lat: String? = null,
    val lon: String? = null,
    val place_rank: String? = null,
    val category: String? = null,
    val type: String? = null,
    val importance: String? = null,
    val addresstype: String? = null,
    val display_name: String? = null,
    val name: String? = null,
    val address: GpsAddress? = null,
    val boundingbox: List<String>? = null
)

class GpsAddress(
    val road: String? = null,
    val city: String? = null,
    val village: String? = null,
    val town: String? = null,
    val state_district: String? = null,
    val state: String? = null,
    val postcode: String? = null,
    val country: String? = null,
    val country_code: String? = null,
    val house_number: String? = null,
)