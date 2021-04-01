package com.depromeet.webtoon.domain.webtoon

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

@Entity
class Webtoon (name:String,
               author:String,
               createdAt:LocalDateTime,
               lastModifiedAt:LocalDateTime) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    var id:Long? = null

    @Column(name="name")
    var name:String = name

    var author:String = author

    val createdAt:LocalDateTime = createdAt

    var lastModifiedAt:LocalDateTime = lastModifiedAt

    fun toWebtoonDto(): WebtoonDto{
        return WebtoonDto(
            id = id!!,
            name = name,
            author = author,
            createdAt = createdAt,
            lastModifiedAt = lastModifiedAt
        )
    }
}