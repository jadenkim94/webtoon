package com.depromeet.webtoon.core.domain.author.service

import com.depromeet.webtoon.core.domain.author.dto.AuthorCreateRequestDto
import com.depromeet.webtoon.core.domain.author.dto.AuthorCreateResponseDto
import com.depromeet.webtoon.core.domain.author.dto.toAuthorCreateResponseDto
import com.depromeet.webtoon.core.domain.author.model.Author
import com.depromeet.webtoon.core.domain.author.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService constructor(val authorRepository: AuthorRepository) {

    fun createAuthor(authorCreateRequestDto: AuthorCreateRequestDto): AuthorCreateResponseDto {
        val author = Author(name = authorCreateRequestDto.name)
        val savedAuthor = authorRepository.save(author)
        return savedAuthor.toAuthorCreateResponseDto()
    }

    fun createAuthors(authorNames: List<String>): List<Author> {
        return authorNames.map { Author(name = it) }
            .let { authorRepository.saveAll(it) }
    }

    /**
     * 이름 기준으로 찾고 결과를 반환합니다.
     * 만약 작가가 없는 경우 새롭게 추가한뒤 함께 반환합니다.
     */
    fun findOrCreateAuthors(authorNames: List<String>): List<Author> {
        require(authorNames.isNotEmpty()) { "조회 사이즈가 0입니다." }

        // 이미 작가가 존재하는지 확인한다.
        val foundAuthors = authorRepository.findAllByName(authorNames)

        // 만약 author가 존재하지 않는 경우 새롭게 추가한다.
        val notSavedAuthors = authorNames - foundAuthors.map { it.name }
        return if (notSavedAuthors.isNotEmpty()) {
            // 새롭게 추가한 작가와 이미 존재하는 작가를 함께 반환
            createAuthors(notSavedAuthors) + foundAuthors
        } else {
            // 이미 존재하는 작가 리스트 반환
            foundAuthors
        }
    }
}
