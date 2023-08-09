package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqIdentitasDto
import com.techno.springbootdasar.domain.dto.request.ReqOperationDto
import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import com.techno.springbootdasar.domain.dto.response.ResFullNameDto
import com.techno.springbootdasar.domain.dto.response.ResOperationDto

interface LogicService {
    fun printName(name : String)
    fun oddsOrEvent(number : Int) : String
    fun fullName(reqIdentitasDto: ReqIdentitasDto) : ResBaseDto<ResFullNameDto>
    fun operation(reqOperationDto: ReqOperationDto) : ResBaseDto<ResOperationDto>
}