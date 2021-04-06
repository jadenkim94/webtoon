package com.depromeet.webtoon.domain.author.dto

import javax.validation.constraints.NotBlank

data class AuthorCreateRequestDto(
    @field:NotBlank(message = "작가이름은 필수입니다.") val name: String
)
