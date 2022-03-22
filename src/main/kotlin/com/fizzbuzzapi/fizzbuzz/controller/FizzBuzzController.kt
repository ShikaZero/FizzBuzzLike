package com.fizzbuzzapi.fizzbuzz.controller

import com.fizzbuzzapi.fizzbuzz.service.FizzBuzzService
import com.fizzbuzzapi.fizzbuzz.statistics.ConvertedNumberStatistics
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong


@RestController
@RequestMapping("api/fizzbuzz")
class FizzBuzzController(
    private val fizzBuzzService: FizzBuzzService,
    private val convertedNumberStatistics: ConvertedNumberStatistics
    ) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("/{int1}/{int2}/{limit}/{str1}/{str2}")
    fun getConvertNumber(
        @PathVariable int1: Int,
        @PathVariable int2: Int,
        @PathVariable limit: Int,
        @PathVariable str1: String,
        @PathVariable str2: String
    ) : List<String> {
        convertedNumberStatistics.counterGetConvertedNumberCalls(mutableMapOf(
            "int1" to int1,
            "int2" to int2,
            "limit" to limit,
            "str1" to str1,
            "str2" to str2
            )
        )

        return fizzBuzzService.getConvertedNumber(
            int1,
            int2,
            limit,
            str1,
            str2
        )
    }

    @GetMapping("/stats")
    fun getConvertedNumber():  MutableMap<String, Any> = convertedNumberStatistics.getCountValue()
}