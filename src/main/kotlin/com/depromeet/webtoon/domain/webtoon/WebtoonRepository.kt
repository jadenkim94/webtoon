package com.depromeet.webtoon.domain.webtoon

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WebtoonRepository : JpaRepository<Webtoon, Long>
