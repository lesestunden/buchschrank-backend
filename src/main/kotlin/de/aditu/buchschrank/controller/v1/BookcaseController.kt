package de.aditu.buchschrank.controller.v1

import de.aditu.buchschrank.client.GpsClient
import de.aditu.buchschrank.config.sanitize
import de.aditu.buchschrank.dto.SaveRequest
import de.aditu.buchschrank.dto.SaveResponse
import de.aditu.buchschrank.model.Bookcase
import de.aditu.buchschrank.repository.BookcaseRepository
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime
import javax.validation.Valid
import javax.validation.Validation
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/v1")
class BookcaseController(val bookcaseRepository: BookcaseRepository,
                         val gpsClient: GpsClient,
                         val saveRequestValidator: SaveRequestValidator) {

    @GetMapping("/bookcase")
    fun all() = bookcaseRepository.findAll().toList()

    @PostMapping("/request")
    fun save(@NotNull @RequestBody request: SaveRequest): SaveResponse {
        if (request.remove == true) {
            return SaveResponse(request.bookcase
                ?.let { bookcaseRepository.findById(it).orElse(null) }
                ?.apply { bookcaseRepository.delete(this) }
                ?.id)
        }

        saveRequestValidator.validate(request)

        val bookcase = request.bookcase?.let {
            bookcaseRepository.findById(it)
                .orElseGet { Bookcase(inserted = ZonedDateTime.now()) }
                .apply { this.lastupdate = ZonedDateTime.now() }
        } ?: Bookcase(inserted = ZonedDateTime.now())
        bookcase.title = request.title?.sanitize()
        bookcase.lat = request.lat
        bookcase.lng = request.lng
        bookcase.link = request.link?.sanitize()
        bookcase.contact = request.contact?.sanitize()
        bookcase.opened = request.opened?.sanitize()
        gpsClient.reverse(bookcase.lat!!, bookcase.lng!!).let { address ->
            bookcase.country = address.country
            bookcase.place = address.place
            bookcase.streethousenumber = address.streethousenumber
            bookcase.postcode = address.postcode
        }
        return SaveResponse(id = bookcaseRepository.save(bookcase).id)
    }

}

@Component
class SaveRequestValidator {

    fun validate(@Valid request: SaveRequest) {

    }
}