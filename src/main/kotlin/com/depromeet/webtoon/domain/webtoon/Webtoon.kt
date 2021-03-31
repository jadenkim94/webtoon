package com.depromeet.webtoon.domain.webtoon

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
class Webtoon (name:String) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    var id:Long? = null

    @Column(name="name")
    var name:String = name
}