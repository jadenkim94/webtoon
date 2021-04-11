package com.depromeet.webtoon.batch

import com.depromeet.webtoon.core.WebtoonCoreRoot
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackageClasses = [WebtoonBatchApplication::class, WebtoonCoreRoot::class])
@EnableBatchProcessing
class WebtoonBatchApplication

fun main(args: Array<String>) {
    runApplication<WebtoonBatchApplication>(*args)
}
