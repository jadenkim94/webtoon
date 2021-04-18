package com.depromeet.webtoon.core.domain.author.model

import com.depromeet.webtoon.core.domain.webtoon.model.Webtoon
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
@EntityListeners(AuditingEntityListener::class)
class Author
// 테스트 목적으로 추가함
constructor(
    id: Long? = null,
    name: String = "",
    webtoons: List<Webtoon> = emptyList(),
    createdAt: LocalDateTime? = null,
    modifiedAt: LocalDateTime? = null,
) {
    constructor() : this(null, "", emptyList())

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    var id: Long? = id

    @Column(name = "name")
    var name: String = name

    @ManyToMany(mappedBy = "authors")
    var webtoons: List<Webtoon>? = webtoons

    @CreatedDate
    var createdAt: LocalDateTime? = createdAt
        private set

    @LastModifiedDate
    var modifiedAt: LocalDateTime? = modifiedAt
        private set

    // TODO 자동화 가능하도록 할것
    override fun toString(): String {
        return "Author(id=$id, name='$name', webtoons=$webtoons, createdAt=$createdAt, modifiedAt=$modifiedAt)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
