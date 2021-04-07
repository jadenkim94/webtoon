package com.depromeet.webtoon.core.domain.author

import com.depromeet.webtoon.core.domain.author.dto.AuthorCreateRequestDto
import com.depromeet.webtoon.core.domain.author.dto.AuthorCreateResponseDto
import com.depromeet.webtoon.core.domain.author.dto.toAuthorCreateResponseDto
import org.springframework.stereotype.Service

@Service
class AuthorService constructor(val authorRepository: AuthorRepository) {

    fun createAuthor(authorCreateRequestDto: AuthorCreateRequestDto): AuthorCreateResponseDto {
        val author = Author(authorCreateRequestDto.name, null)
        val savedAuthor = authorRepository.save(author)
        return savedAuthor.toAuthorCreateResponseDto()
    }
}
