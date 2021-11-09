package de.aditu.buchschrank.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["de.aditu.buchschrank.model"])
@EnableJpaRepositories(basePackages = ["de.aditu.buchschrank.repository"])
class JpaConfig