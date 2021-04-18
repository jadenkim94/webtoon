package com.depromeet.webtoon.core.domain.webtoon.model

import com.depromeet.webtoon.core.domain.author.model.Author
import com.depromeet.webtoon.core.type.WebtoonSite
import com.depromeet.webtoon.core.type.WebtoonSite.NONE
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
@EntityListeners(AuditingEntityListener::class)
class Webtoon constructor(
    id: Long? = null,
    title: String = "",
    site: WebtoonSite = NONE,
    authors: List<Author> = mutableListOf(),
    createdAt: LocalDateTime? = null,
    modifiedAt: LocalDateTime? = null,
) {
    constructor() : this(id = null)

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    var id: Long? = id

    @Column(name = "title")
    var title: String = title

    @Column(name = "site")
    @Enumerated(EnumType.STRING)
    var site: WebtoonSite = site

    @ManyToMany
    var authors: MutableList<Author> = authors.toMutableList()

    @CreatedDate
    var createdAt: LocalDateTime? = createdAt
        private set

    @LastModifiedDate
    var modifiedAt: LocalDateTime? = modifiedAt
        private set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Webtoon

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
