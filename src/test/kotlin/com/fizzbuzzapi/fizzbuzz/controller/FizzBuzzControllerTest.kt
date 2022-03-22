package com.fizzbuzzapi.fizzbuzz.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class FizzBuzzControllerTest @Autowired constructor(
    var mockMvc: MockMvc,
    var objectMapper: ObjectMapper
    ){

    val baseURL = "/api/fizzbuzz"
    @Nested
    @DisplayName("GET /stats")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetStatistics {
        @Test
        fun `should return the expected stats`() {

            //given
            val int1 = 3
            val int2 = 5
            val limit = 15
            val str1 = "fizz"
            val str2 = "buzz"

            val int3 = 7
            val limit2 = 28
            val str3 = "eren"
            val str4 = "jaeger"

            val expectedResponse = mutableMapOf(
                "int1" to 3,
                "int2" to 5,
                "limit" to 15,
                "str1" to "fizz",
                "str2" to "buzz",
                "count" to 5
            )

            //when
            for (i in 0..4) {
                mockMvc.get("$baseURL/$int1/$int2/$limit/$str1/$str2")
            }
            for (i in 0..3) {
                mockMvc.get("$baseURL/$int2/$int3/$limit2/$str3/$str4")
            }

            //then
            mockMvc.get("$baseURL/stats")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    content { json(objectMapper.writeValueAsString(expectedResponse)) }
                }
        }
    }

    @Nested
    @DisplayName("GET /api/fizzbuzz")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetConvertedNumbers{
        @Test
        fun `should return a list of all expected strings`() {

            //given
            val int1 = 3
            val int2 = 5
            val limit = 15
            val str1 = "fizz"
            val str2 = "buzz"

            //when/then
            mockMvc.get("$baseURL/$int1/$int2/$limit/$str1/$str2")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0]"){
                        value("1")
                    }
                    jsonPath("$[1]"){
                        value("2")
                    }
                    jsonPath("$[2]"){
                        value("fizz")
                    }
                    jsonPath("$[3]"){
                        value("4")
                    }
                    jsonPath("$[4]"){
                        value("buzz")
                    }
                    jsonPath("$[5]"){
                        value("fizz")
                    }
                    jsonPath("$[6]"){
                        value("7")
                    }
                    jsonPath("$[7]"){
                        value("8")
                    }
                    jsonPath("$[8]"){
                        value("fizz")
                    }
                    jsonPath("$[9]"){
                        value("buzz")
                    }
                    jsonPath("$[10]"){
                        value("11")
                    }
                    jsonPath("$[11]"){
                        value("fizz")
                    }
                    jsonPath("$[12]"){
                        value("13")
                    }
                    jsonPath("$[13]"){
                        value("14")
                    }
                    jsonPath("$[14]"){
                        value("fizzbuzz")
                    }
                }
        }
    }

}