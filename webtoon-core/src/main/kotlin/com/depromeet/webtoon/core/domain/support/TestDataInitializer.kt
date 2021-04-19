package com.depromeet.webtoon.core.domain.support

import com.depromeet.webtoon.core.domain.author.model.Author
import com.depromeet.webtoon.core.domain.author.repository.AuthorRepository
import com.depromeet.webtoon.core.domain.webtoon.model.Webtoon
import com.depromeet.webtoon.core.domain.webtoon.repository.WebtoonRepository
import com.depromeet.webtoon.core.type.WebtoonSite.DAUM
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class TestDataInitializer(
    val webtoonRepository: WebtoonRepository,
    val authorRepository: AuthorRepository
) {

    @PostConstruct
    fun initTestData() {
        for (i in 1..10) {
            val author = Author(id = i.toLong(), "author$i", mutableListOf())
            authorRepository.save(author)

            val webtoon = Webtoon(id = i.toLong(), site = DAUM, title = "test$i", authors = mutableListOf(author))
            webtoonRepository.save(webtoon)
        }
    }
}
