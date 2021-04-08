package com.depromeet.webtoon.batch

import com.depromeet.webtoon.core.WebtoonCoreRoot
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackageClasses = [WebtoonBatchApplication::class, WebtoonCoreRoot::class])
class WebtoonBatchApplication

fun main(args: Array<String>) {
    runApplication<WebtoonBatchApplication>(*args)
}
