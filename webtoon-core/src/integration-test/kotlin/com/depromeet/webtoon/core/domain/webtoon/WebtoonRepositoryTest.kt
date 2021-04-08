package com.depromeet.webtoon.core.domain.webtoon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WebtoonRepositoryTest constructor(
    var webtoonRepository: WebtoonRepository
) : FunSpec({

    test("Webtoon 생성 및 반환 확인") {
        // given
        val testWebtoon = Webtoon("웹툰", emptyList())

        // when
        val savedWebtoon = webtoonRepository.saveAndFlush(testWebtoon)

        // then
        val foundWebtoon = webtoonRepository.getOne(savedWebtoon.id!!)
        foundWebtoon.id.shouldNotBeNull()
        foundWebtoon.id shouldNotBe null
    }
})
