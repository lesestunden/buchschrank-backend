package de.aditu.buchschrank.model

import java.time.ZonedDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Bookcase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String? = null,
    var streethousenumber: String? = null,
    var postcode: String? = null,
    var place: String? = null,
    var country: String? = null,
    var lat: Double? = null,
    var lng: Double? = null,
    var link: String? = null,
    var contact: String? = null,
    var opened: String? = null,
    var inserted: ZonedDateTime? = null,
    var lastupdate: ZonedDateTime? = null,
)