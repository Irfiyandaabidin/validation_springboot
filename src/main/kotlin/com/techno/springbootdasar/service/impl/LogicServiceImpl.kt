package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.request.ReqIdentitasDto
import com.techno.springbootdasar.domain.dto.request.ReqOperationDto
import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import com.techno.springbootdasar.domain.dto.response.ResFullNameDto
import com.techno.springbootdasar.domain.dto.response.ResOperationDto
import com.techno.springbootdasar.service.LogicService
import org.springframework.stereotype.Service

@Service
class LogicServiceImpl : LogicService{
    override fun printName(name: String) {
        println("My name is $name")
    }

    override fun oddsOrEvent(number : Int) : String {
        if(number % 2 == 0)
            return "Event"
        else
            return "Odds"
    }

    override fun fullName(reqIdentitasDto: ReqIdentitasDto): ResBaseDto<ResFullNameDto> {
        val fullNameTemp = reqIdentitasDto.firstName + " " + reqIdentitasDto.lastName
        val resFUllName = ResFullNameDto(
            firstName = reqIdentitasDto.firstName,
            lastName = reqIdentitasDto.lastName,
            fullName = fullNameTemp
        )
        return ResBaseDto(
            data = resFUllName
        )
    }

    override fun operation(reqOperationDto: ReqOperationDto): ResBaseDto<ResOperationDto> {
        if( reqOperationDto.number1 != null && reqOperationDto.number2 != null)
        {
            if(reqOperationDto.mathOperator == "addition")
            {
                val operationTemp = ResOperationDto(
                    number1 = reqOperationDto.number1,
                    number2 = reqOperationDto.number2,
                    result = reqOperationDto.number1.toFloat() + reqOperationDto.number2.toFloat()
                )
                return ResBaseDto(
                    data = operationTemp
                )
            } else if (reqOperationDto.mathOperator == "substraction") {
                val operationTemp = ResOperationDto(
                    number1 = reqOperationDto.number1,
                    number2 = reqOperationDto.number2,
                    result = reqOperationDto.number1.toFloat() - reqOperationDto.number2.toFloat()
                )
                return ResBaseDto(
                    data = operationTemp
                )
            } else if (reqOperationDto.mathOperator == "division") {
                val operationTemp = ResOperationDto(
                    number1 = reqOperationDto.number1,
                    number2 = reqOperationDto.number2,
                    result = reqOperationDto.number1.toFloat() / reqOperationDto.number2.toFloat()
                )
                return ResBaseDto(
                    data = operationTemp
                )
            } else if (reqOperationDto.mathOperator == "multiple") {
                val operationTemp = ResOperationDto(
                    number1 = reqOperationDto.number1,
                    number2 = reqOperationDto.number2,
                    result = reqOperationDto.number1.toFloat() * reqOperationDto.number2.toFloat()
                )
                return ResBaseDto(
                    data = operationTemp
                )
            }
        }
        return ResBaseDto(
                status = false,
                message = "False input",
                data = null
        )
    }
}