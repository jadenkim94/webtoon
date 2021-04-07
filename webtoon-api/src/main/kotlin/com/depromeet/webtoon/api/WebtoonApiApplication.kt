package com.depromeet.webtoon.api

import com.depromeet.webtoon.core.WebtoonCoreRoot
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(WebtoonCoreRoot::class)
class WebtoonApiApplication

fun main(args: Array<String>) {
    runApplication<WebtoonApiApplication>(*args)
}
