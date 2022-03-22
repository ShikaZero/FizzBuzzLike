package com.fizzbuzzapi.fizzbuzz.statistics

import com.fizzbuzzapi.fizzbuzz.rules.Rules
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

@Component
class ConvertedNumberStatistics(val rules: Rules) {

    private val counter = 0
    private var listOfConvertedNumberCountedStats : MutableList<MutableMap<String, Any>> = mutableListOf()

    fun counterGetConvertedNumberCalls(parameterConvertedNumber: MutableMap<String, Any>){
        if(listOfConvertedNumberCountedStats.isEmpty()) {
            listOfConvertedNumberCountedStats.add(
                parameterConvertedNumber.initCountStatsValue()
            )
        }

        listOfConvertedNumberCountedStats.find {
            rules.checkIfMappedConvertedStatsValueAreSimilar(Pair(it, parameterConvertedNumber))
        }?.let { convertedNumber ->
            convertedNumber.replace("count", convertedNumber.getValue("count").toString().toInt().inc() )
        }?: listOfConvertedNumberCountedStats.add(parameterConvertedNumber.initCountStatsValue())

    }

    private fun MutableMap<String, Any>.initCountStatsValue() = this.plus("count" to counter).toMutableMap()

    fun getCountValue(): MutableMap<String, Any> {
        listOfConvertedNumberCountedStats.sortBy { it.getValue("count").toString() }
        return listOfConvertedNumberCountedStats.last()
    }

}