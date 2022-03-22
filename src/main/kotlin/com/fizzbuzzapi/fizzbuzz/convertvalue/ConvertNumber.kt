package com.fizzbuzzapi.fizzbuzz.convertvalue

import com.fizzbuzzapi.fizzbuzz.rules.Rules
import org.springframework.stereotype.Component

@Component
class ConvertNumber(val rules: Rules): ConvertNumberInterface {

    override fun convertNumber(
        input: Int,
        str1: String,
        str2: String
    ) = when {
        rules.divisibleBy3And5(input)-> str1 + str2
        rules.divisibleBy3(input) -> str1
        rules.divisibleBy5(input) -> str2
        else -> input.toString()
    }
}