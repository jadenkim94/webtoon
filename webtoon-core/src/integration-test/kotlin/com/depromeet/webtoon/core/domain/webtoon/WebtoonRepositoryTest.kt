package com.depromeet.webtoon.core.domain.webtoon

import com.depromeet.webtoon.core.domain.webtoon.model.Webtoon
import com.depromeet.webtoon.core.domain.webtoon.repository.WebtoonRepository
import com.depromeet.webtoon.core.type.WebtoonSite
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WebtoonRepositoryTest constructor(
    var webtoonRepository: WebtoonRepository
) : FunSpec({

    test("Webtoon 생성 및 반환 확인") {
        // given
        val testWebtoon = Webtoon(title = "test", authors = listOf(), site = WebtoonSite.NAVER)

        // when
        val savedWebtoon = webtoonRepository.saveAndFlush(testWebtoon)

        // then
        val foundWebtoon = webtoonRepository.getOne(savedWebtoon.id!!)
        foundWebtoon.id.shouldNotBeNull()
        foundWebtoon.id shouldNotBe null
    }
})
