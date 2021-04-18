package com.depromeet.webtoon.core.domain.author.repository

import com.depromeet.webtoon.core.domain.author.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
    fun findAllByName(names: List<String>): List<Author>
}
