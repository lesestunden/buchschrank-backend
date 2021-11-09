package de.aditu.buchschrank.repository

import de.aditu.buchschrank.model.Bookcase
import org.springframework.data.repository.CrudRepository

interface BookcaseRepository : CrudRepository<Bookcase, Long>