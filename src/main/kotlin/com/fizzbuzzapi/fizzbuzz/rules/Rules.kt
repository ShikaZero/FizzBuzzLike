package com.fizzbuzzapi.fizzbuzz.rules

import org.springframework.stereotype.Component

@Component
class Rules : RulesInterface {
    override fun divisibleBy3(input: Int): Boolean = input % 3 == 0

    override fun divisibleBy5(input: Int): Boolean = input % 5 == 0

    override fun divisibleBy3And5(input: Int): Boolean = divisibleBy3(input) && divisibleBy5(input)

    override fun checkIfMappedConvertedStatsValueAreSimilar(values :Pair<Map<String, Any>, Map<String, Any>>): Boolean =
    values.first.getValue("int1") == values.second.getValue("int1") &&
    values.first.getValue("int2") == values.second.getValue("int2") &&
    values.first.getValue("limit") == values.second.getValue("limit") &&
    values.first.getValue("str1") == values.second.getValue("str1") &&
    values.first.getValue("str2") == values.second.getValue("str2")
}