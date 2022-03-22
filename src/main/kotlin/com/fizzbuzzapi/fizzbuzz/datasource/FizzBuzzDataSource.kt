package com.fizzbuzzapi.fizzbuzz.datasource

import com.fizzbuzzapi.fizzbuzz.convertvalue.ConvertNumber
import org.springframework.stereotype.Component

@Component
class FizzBuzzDataSource(val convertNumber: ConvertNumber): FizzBuzzDataSourceInterface {

    override fun findConvertedNumber(
        int1: Int,
        int2: Int,
        limit: Int,
        str1: String,
        str2: String
    ): List<String> {
        val listOfConvertedNumber = mutableListOf<String>()
        for(input in 1..limit){
            listOfConvertedNumber.add(convertNumber.convertNumber(input, str1, str2))
        }
        return listOfConvertedNumber
    }
}