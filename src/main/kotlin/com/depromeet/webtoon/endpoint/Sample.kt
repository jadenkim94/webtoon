package com.depromeet.webtoon.endpoint

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Sample {

    @GetMapping("/")
    fun homeController(): String {
        val sample = SampleDto("test")
        sample.age = 20 // setter

        return sample.nameTwice()
    }

    fun SampleDto.nameTwice() = "${this.name.repeat(2)} gggggg"
}
