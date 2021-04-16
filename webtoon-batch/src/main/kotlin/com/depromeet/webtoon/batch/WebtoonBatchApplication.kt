package com.depromeet.webtoon.batch

import com.depromeet.webtoon.core.WebtoonCoreRoot
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.system.exitProcess


@SpringBootApplication(scanBasePackageClasses = [WebtoonBatchApplication::class, WebtoonCoreRoot::class])
@EnableBatchProcessing
class WebtoonBatchApplication

fun main(args: Array<String>) {
    val applicationContext = runApplication<WebtoonBatchApplication>(*args)
    // kill process after batch jobs
    exitProcess(SpringApplication.exit(applicationContext))
}
