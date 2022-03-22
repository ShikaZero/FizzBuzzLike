package com.fizzbuzzapi.fizzbuzz.datasource

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class FizzBuzzDataSourceTest(@Autowired var fizzBuzzDataSource: FizzBuzzDataSource){

    @Test
    fun `should return the output list with a limit`(){
        //given
        val expectedOutput = listOf("1","2")

        //when
        val inputNumber = fizzBuzzDataSource.findConvertedNumber(0,0,2,"","")

        //then
        assertEquals(expectedOutput, inputNumber)
    }

    @Test
    fun `should convert the first integer input depending on the first string input`(){

        //given
        val expectedOutput = listOf("1","2","fizz","4")

        //when
        val inputNumber = fizzBuzzDataSource.findConvertedNumber(3,0,4,"fizz","")

        //then
        assertEquals(expectedOutput, inputNumber)
    }

    @Test
    fun `should convert the second integer input depending on the second string input`(){

        //given
        val expectedOutput = listOf("1","2","fizz","4","buzz","fizz")

        //when
        val inputNumber = fizzBuzzDataSource.findConvertedNumber(3,0,6,"fizz","buzz")

        //then
        assertEquals(expectedOutput, inputNumber)
    }

    @Test
    fun `should convert the sum of first and second string depending on the first and second integer`(){

        //given
        val expectedOutput = listOf(
            "1","2","fizz","4","buzz","fizz","7","8",
            "fizz", "buzz", "11", "fizz", "13", "14",
            "fizzbuzz", "16", "17", "fizz"
        )

        //when
        val inputNumber = fizzBuzzDataSource.findConvertedNumber(3,5,18,"fizz","buzz")

        //then
        assertEquals(expectedOutput, inputNumber)
    }
}