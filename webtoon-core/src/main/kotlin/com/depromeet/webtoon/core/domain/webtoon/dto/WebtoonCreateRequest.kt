package com.depromeet.webtoon.core.domain.webtoon.dto

import com.depromeet.webtoon.core.domain.author.model.Author
import com.depromeet.webtoon.core.type.WebtoonSite
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class WebtoonCreateRequest(
    @field:NotBlank(message = "웹툰 제목은 필수입니다.")
    val title: String,
    val site: WebtoonSite,
    @field:NotEmpty(message = "작가 정보는 필수입니다.")
    val authors: List<Author>
)
