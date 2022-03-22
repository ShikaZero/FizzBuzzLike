package com.fizzbuzzapi.fizzbuzz.rules

interface RulesInterface {

    fun divisibleBy3(input: Int): Boolean

    fun divisibleBy5(input: Int): Boolean

    fun divisibleBy3And5(input: Int): Boolean

    fun checkIfMappedConvertedStatsValueAreSimilar(values: Pair<Map<String, Any>, Map<String, Any>>): Boolean
}