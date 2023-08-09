package com.techno.springbootdasar.config

import com.techno.springbootdasar.service.LogicService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class ContohConfig (
    private val logicService: LogicService
) {
    @Bean
    fun printName() {
        logicService.printName("irfiyanda abidin")
    }
    @Bean
    fun getOddsOrEvent() {
        val result : String = logicService.oddsOrEvent(9)
        println("Number result is $result")
    }
}