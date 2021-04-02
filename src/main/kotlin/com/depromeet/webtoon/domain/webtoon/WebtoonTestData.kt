package com.depromeet.webtoon.domain.webtoon

import com.depromeet.webtoon.domain.author.Author
import com.depromeet.webtoon.domain.author.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class WebtoonTestData(@Autowired val webtoonRepository: WebtoonRepository, @Autowired val authorRepository: AuthorRepository) {

    @PostConstruct
    fun initTestData() {
        for (i in 1..10) {
            val author = Author("author$i", null)
            authorRepository.save(author)

            val authorList = ArrayList<Author>()
            authorList.add(author)
            val webtoon = Webtoon("test$i", authorList)
            webtoonRepository.save(webtoon)
        }
    }
}
