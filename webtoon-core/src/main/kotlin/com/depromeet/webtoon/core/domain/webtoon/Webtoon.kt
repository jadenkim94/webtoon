package com.depromeet.webtoon.core.domain.webtoon

import com.depromeet.webtoon.core.domain.author.Author
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
class Webtoon(
    name: String,
    authors: List<Author>
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "name")
    var name: String = name

    @ManyToMany
    var authors: List<Author> = authors

    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.MIN
        private set

    @LastModifiedDate
    var lastModifiedAt: LocalDateTime = LocalDateTime.MIN
        private set
}
