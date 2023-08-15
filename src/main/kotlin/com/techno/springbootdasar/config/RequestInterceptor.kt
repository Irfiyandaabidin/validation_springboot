package com.techno.springbootdasar.config

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.fasterxml.jackson.databind.ObjectMapper

@Component
class RequestInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        fun convertObjectToJson(obj: Any): String {
            val objectMapper = ObjectMapper()
            return objectMapper.writeValueAsString(obj)
        }
        val apiKey = request.getHeader("api-key")
        if(apiKey != "api-key") {
            val result = mapOf<String, String>("status" to "False", "message" to "you don't have permission")
            response.writer.write(convertObjectToJson(result))
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            response.status = 401
            return false
        }
        return true
    }
}