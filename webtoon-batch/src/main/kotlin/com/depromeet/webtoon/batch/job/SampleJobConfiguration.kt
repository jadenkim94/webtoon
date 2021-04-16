package com.depromeet.webtoon.batch.job

import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SampleJobConfiguration(
    val jobBuilderFactory: JobBuilderFactory, 
    val stepBuilderFactory: StepBuilderFactory
) {
    private val log = LoggerFactory.getLogger(SampleJobConfiguration::class.java)

    @Bean
    fun sampleJob(): Job {
        return jobBuilderFactory.get("sampleJob")
            .start(sampleStep(null))
            .build()
    }

    @Bean
    @JobScope
    fun sampleStep(@Value("#{jobParameters[requestDate]}") requestDate: String?): Step {
        return stepBuilderFactory.get("sampleStep")
            .tasklet { contribution, chunckContext ->
                log.info("helloWorld $requestDate")
                RepeatStatus.FINISHED
            }
            .build()
    }
}
