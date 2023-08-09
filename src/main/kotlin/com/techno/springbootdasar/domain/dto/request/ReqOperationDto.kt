package com.techno.springbootdasar.domain.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ReqOperationDto(
    val number1 : Int? = null,
    val number2 : Int? = null,
    val mathOperator : String? = null
)
