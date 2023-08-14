package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqDecodeJwtDto
import com.techno.springbootdasar.domain.dto.request.ReqExampleJwtDto
import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import com.techno.springbootdasar.domain.dto.response.ResExampleJwtDto
import com.techno.springbootdasar.domain.dto.response.ResUserDto
import com.techno.springbootdasar.domain.dto.response.ResValidateLoginDto
import com.techno.springbootdasar.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/api/auth")
class AuthController (
        private val authService: AuthService
){
    @PostMapping("/login")
    fun login(@RequestBody reqExampleJwtDto: ReqExampleJwtDto): ResponseEntity<ResBaseDto<ResExampleJwtDto>> {
        val response = authService.insert(reqExampleJwtDto)
        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/validate-token")
    fun validate(@RequestBody reqDecodeJwtDto: ReqDecodeJwtDto) : ResponseEntity<ResBaseDto<ResValidateLoginDto>> {
        val response = authService.validateToken(reqDecodeJwtDto)
        return ResponseEntity.ok().body(response)
    }
}