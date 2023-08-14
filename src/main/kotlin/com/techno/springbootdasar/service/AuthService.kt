package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqDecodeJwtDto
import com.techno.springbootdasar.domain.dto.request.ReqExampleJwtDto
import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import com.techno.springbootdasar.domain.dto.response.ResExampleJwtDto
import com.techno.springbootdasar.domain.dto.response.ResValidateLoginDto

interface AuthService {
    fun insert(reqExampleJwtDto: ReqExampleJwtDto) : ResBaseDto<ResExampleJwtDto>
    fun validateToken(reqDecodeJwtDto: ReqDecodeJwtDto) : ResBaseDto<ResValidateLoginDto>
//    fun delete(id: Long) : ResBaseDto<Any>
}