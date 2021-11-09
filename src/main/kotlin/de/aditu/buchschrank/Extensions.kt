package de.aditu.buchschrank.config

import org.jsoup.Jsoup
import org.jsoup.safety.Whitelist

fun String.sanitize() = Jsoup.clean(this, Whitelist.basic())