package com.depromeet.webtoon.api.endpoint.author

import com.depromeet.webtoon.core.domain.author.dto.AuthorCreateRequestDto
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.FunSpec
import io.mockk.mockk
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

// @WebMvcTest(controllers = [AuthorController::class])
/*
 WebMvcTest 사용시 Service 빈을 들고오지 않아 AuthorController 생성 실패
 -> mockService 객체를 생성해 주입해주면 되나? but how..?
 Controller 같은 경우 UnitTest 를 어떤식으로 작성하는지..
 어렴풋한 기억에 controller 의 경우 unit test 작성할 필요가 굳이 없었던것 같기도..
 */
class AuthorControllerTest : FunSpec({
    lateinit var authorController: AuthorController
    lateinit var mockMvc: MockMvc

    beforeTest {
        authorController = AuthorController(mockk(relaxed = true))
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build()
    }

    test("POST /api/v1/author") {
        val authorCreateRequestDto = AuthorCreateRequestDto("author")
        val objectMapper = ObjectMapper()
        mockMvc.perform(
            post("/api/v1/author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authorCreateRequestDto))
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("id").exists())
        // TODO 수정 필요
//            .andExpect(jsonPath("name").value("author"))
//            .andExpect(jsonPath("createdAt").exists())
//            .andExpect(jsonPath("lastModifiedAt").exists())
    }
})
