package com.fizzbuzzapi.fizzbuzz.datasource

interface FizzBuzzDataSourceInterface {

    fun findConvertedNumber(
        int1: Int,
        int2: Int,
        limit: Int,
        str1: String,
        str2: String
    ) : List<String>
}