package com.depromeet.webtoon.domain.author

import com.depromeet.webtoon.domain.author.dto.AuthorCreateRequestDto
import com.depromeet.webtoon.domain.author.dto.AuthorCreateResponseDto
import com.depromeet.webtoon.domain.author.dto.toAuthorCreateResponseDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthorService(@Autowired val authorRepository: AuthorRepository) {

    fun createAuthor(authorCreateRequestDto: AuthorCreateRequestDto): AuthorCreateResponseDto {
        val author = Author(authorCreateRequestDto.name, null)
        val savedAuthor = authorRepository.save(author)
        return savedAuthor.toAuthorCreateResponseDto()
    }
}
