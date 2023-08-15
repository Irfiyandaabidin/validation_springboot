package com.techno.springbootdasar.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.techno.springbootdasar.util.JwtGenerator
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class LoginInterceptor : HandlerInterceptor {
    fun convertObjectToJson(obj: Any): String {
        val objectMapper = ObjectMapper()
        return objectMapper.writeValueAsString(obj)
    }
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token = request.getHeader("authToken")
        if(token == null) {
            val result = mapOf<String, String>("status" to "False", "message" to "you don't have token")
            response.writer.write(convertObjectToJson(result))
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            response.status = 401
            return false
        }
        try {
            val claims = JwtGenerator().decodeJWT(token)
            if(claims.expiration.before(Date(System.currentTimeMillis()))){
                return false
            }
            println(claims.expiration)
            println(Date(System.currentTimeMillis()))
            return true
        } catch (e: Exception) {
            val result = mapOf<String, String>("status" to "False", "message" to "expired token or invalid token")
            response.writer.write(convertObjectToJson(result))
            response.characterEncoding = "UTF-8"
            response.status = 401
            return false
        }
    }
}