package com.techno.springbootdasar.service.impl

import at.favre.lib.crypto.bcrypt.BCrypt
import com.techno.springbootdasar.domain.dto.request.ReqDecodeJwtDto
import com.techno.springbootdasar.domain.dto.request.ReqExampleJwtDto
import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import com.techno.springbootdasar.domain.dto.response.ResDecodeJwtDto
import com.techno.springbootdasar.domain.dto.response.ResExampleJwtDto
import com.techno.springbootdasar.domain.dto.response.ResValidateLoginDto
import com.techno.springbootdasar.domain.entity.TokenEntity
import com.techno.springbootdasar.exception.CustomExceptionHandler
import com.techno.springbootdasar.repository.AuthRepository
import com.techno.springbootdasar.repository.UserRepository
import com.techno.springbootdasar.service.AuthService
import com.techno.springbootdasar.util.AESUtils
import com.techno.springbootdasar.util.JwtGenerator
import org.bouncycastle.jcajce.provider.symmetric.AES
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Service
class AuthServiceImpl (
        private val authRepository : AuthRepository,
        private val userRepository: UserRepository
) : AuthService {
    override fun insert(reqExampleJwtDto: ReqExampleJwtDto): ResBaseDto<ResExampleJwtDto> {
        val userData = userRepository.findByUsername(reqExampleJwtDto.username!!) ?: throw CustomExceptionHandler("Username or password not match")
        val passwordVerifier = BCrypt.verifyer()
        val passwordMatched = passwordVerifier.verify(reqExampleJwtDto.password!!.toCharArray(), userData.password)
        if(!passwordMatched.verified)
            throw CustomExceptionHandler("Username or password not match")
        println(passwordMatched)
        val exp = 300000L
        val expired = LocalDateTime.ofInstant(Instant.ofEpochMilli(exp), ZoneId.systemDefault())
        val token = JwtGenerator().createJWT(
                reqExampleJwtDto.id.toString(),
                reqExampleJwtDto.username!!,
                exp
        )
        val data = TokenEntity(
                token = token,
                expired = expired,
                idUser = userData,
        )
        val entity = authRepository.save(data)
        val response = ResExampleJwtDto(
                id = entity.id,
                token = entity.token
        )
        return ResBaseDto(data = response)
    }

    override fun validateToken(reqDecodeJwtDto: ReqDecodeJwtDto): ResBaseDto<ResValidateLoginDto> {
        val claims = JwtGenerator().decodeJWT(reqDecodeJwtDto.token!!)
        val data = userRepository.findByUsername(AESUtils.decrypt(claims.subject, "TECHNOSECRET"))
        val dataResponse = ResValidateLoginDto(
                id = data!!.id!!.toInt(),
                name = data!!.name,
                username = data!!.username,
                email = data!!.email
        )
       return ResBaseDto(data = dataResponse)
    }
//
//    override fun delete(id: Long): ResBaseDto<Any> {
//
//    }
}