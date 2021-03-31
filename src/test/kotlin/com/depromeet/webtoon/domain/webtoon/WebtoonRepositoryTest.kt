package com.depromeet.webtoon.domain.webtoon


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WebtoonRepositoryTest @Autowired constructor(val webtoonRepository: WebtoonRepository) {

    @Test
    fun 생성_조회_테스트() {
        // given
        val testWebtoon = Webtoon("웹툰")

        // when
        val savedWebtoon = webtoonRepository.save(testWebtoon)

        // then
        val foundWebtoon = webtoonRepository.getOne(savedWebtoon.id!!)
        assertThat(foundWebtoon.id).isNotNull()


    }
}