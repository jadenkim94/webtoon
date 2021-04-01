package com.depromeet.webtoon.domain.webtoon

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class WebtoonTestData{

    @Autowired
    private lateinit var webtoonRepository: WebtoonRepository

    @PostConstruct
    fun initTestData(){
        for(i in 1..10){
            val webtoon = Webtoon("test$i")
            webtoonRepository.save(webtoon)
        }
    }


}