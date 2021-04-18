package com.depromeet.webtoon.core.application.imports

import com.depromeet.webtoon.core.type.WebtoonSite
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import java.time.DayOfWeek

@SpringBootTest
class WebtoonImportServiceTest(
    var webtoonImportService: WebtoonImportService
) : FunSpec({

    test("import 후 정상 저장 확인 테스트") {
        // given
        val importRequest = webtoonImportRequestFixture(
            title = "드래곤볼",
            authors = listOf("토리야미 아키라"),
            dayOfWeeks = listOf(DayOfWeek.MONDAY),
            site = WebtoonSite.NAVER,
            genres = listOf("배틀"),
            score = 4.95,
            popular = 2
        )

        // when
        val webtoonResult = webtoonImportService.importWebtoon(importRequest)

        // then
        with(webtoonResult) {
            this.id shouldNotBe null
            this.title shouldBe importRequest.title
            this.site shouldBe importRequest.site
        }
    }
})
