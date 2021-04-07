package com.depromeet.webtoon.core.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@Configuration
@EnableJpaAuditing(modifyOnCreate = true)
class AuditConfig
