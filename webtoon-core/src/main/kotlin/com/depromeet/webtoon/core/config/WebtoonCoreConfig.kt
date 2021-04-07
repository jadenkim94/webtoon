package com.depromeet.webtoon.core.config

import com.depromeet.webtoon.core.WebtoonCoreRoot
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan(basePackageClasses = [WebtoonCoreRoot::class])
@EnableJpaRepositories(basePackageClasses = [WebtoonCoreRoot::class])
class WebtoonCoreConfig
