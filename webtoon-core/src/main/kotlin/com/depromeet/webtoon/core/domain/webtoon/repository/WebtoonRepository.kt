package com.depromeet.webtoon.core.domain.webtoon.repository

import com.depromeet.webtoon.core.domain.webtoon.model.Webtoon
import com.depromeet.webtoon.core.type.WebtoonSite
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WebtoonRepository : JpaRepository<Webtoon, Long> {
    fun findBySiteAndTitle(site: WebtoonSite, title: String): Webtoon?
}
