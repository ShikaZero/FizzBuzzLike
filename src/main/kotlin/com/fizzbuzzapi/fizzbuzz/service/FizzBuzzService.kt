package com.fizzbuzzapi.fizzbuzz.service

import com.fizzbuzzapi.fizzbuzz.datasource.FizzBuzzDataSource
import org.springframework.stereotype.Service

@Service
class FizzBuzzService(private val dataSource: FizzBuzzDataSource) {

    fun getConvertedNumber(
        int1: Int,
        int2: Int,
        limit: Int,
        str1: String,
        str2: String
    ) : List<String> = dataSource.findConvertedNumber(
        int1,
        int2,
        limit,
        str1,
        str2
    )


}