package de.aditu.buchschrank.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class SaveRequest(
    @field:BookcaseExists(message = "Der Bücherschrank wurde nicht gefunden")
    var bookcase: Long? = null,
    var remove: Boolean? = null,

    @field:NotNull(message = "Bitte Bezeichnung angeben (z.B. Schrank am Eingang Hauptbahnhof)")
    @field:Size(min = 1, message = "Bitte Bezeichnung angeben (z.B. Schrank am Eingang Hauptbahnhof)")
    var title: String?,

    @field:NotZero(message = "Der Breitengrad muss eingegeben werden")
    var lat: Double?,

    @field:NotZero(message = "Der Längengrad muss eingegeben werden")
    var lng: Double?,

    var link: String?,
    var contact: String?,
    var opened: String?
)