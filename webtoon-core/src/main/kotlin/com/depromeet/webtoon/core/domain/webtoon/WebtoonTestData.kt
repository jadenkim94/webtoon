package com.depromeet.webtoon.core.domain.webtoon

import com.depromeet.webtoon.core.domain.author.model.Author
import com.depromeet.webtoon.core.domain.author.repository.AuthorRepository
import com.depromeet.webtoon.core.domain.webtoon.model.Webtoon
import com.depromeet.webtoon.core.domain.webtoon.repository.WebtoonRepository
import com.depromeet.webtoon.core.type.WebtoonSite.DAUM
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class WebtoonTestData(
    @Autowired val webtoonRepository: WebtoonRepository,
    @Autowired val authorRepository: AuthorRepository
) {

    @PostConstruct
    fun initTestData() {
        for (i in 1..10) {
            val author = Author(id = i.toLong(), "author$i", emptyList())
            authorRepository.save(author)

            val webtoon = Webtoon(id = i.toLong(), site = DAUM, title = "test$i", authors = listOf(author))
            webtoonRepository.save(webtoon)
        }
    }
}
