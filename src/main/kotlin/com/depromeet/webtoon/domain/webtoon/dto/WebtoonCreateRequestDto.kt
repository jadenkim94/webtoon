package com.depromeet.webtoon.domain.webtoon.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class WebtoonCreateRequestDto(
    @field:NotBlank(message = "웹툰 제목은 필수입니다.") val name: String,
    @field:NotEmpty(message = "작가 정보는 필수입니다.") val authors: List<WebtoonAuthorVo>
)
