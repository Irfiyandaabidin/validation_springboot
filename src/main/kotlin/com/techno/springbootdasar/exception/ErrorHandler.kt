package com.techno.springbootdasar.exception

import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)

class ErrorHandler {
    @ExceptionHandler(Exception::class)
    fun handlerException(exception: Exception): ResponseEntity<ResBaseDto<String>> {
        println("Error General!!")
        exception.printStackTrace()
        val result = ResBaseDto(false, message = "Something Went Wrong", data = null, errors = exception.message, code = 400)
        return ResponseEntity.badRequest().body(result)
    }
    @ExceptionHandler(CustomExceptionHandler::class)
    fun handleCustomException(exception: RuntimeException) : ResponseEntity<Any> {
        val result = ResBaseDto(false, message = "Something Went Wrong", data = null, errors = exception.message, code = 400)
        return ResponseEntity.badRequest().body(result)
    }

    @ExceptionHandler (MethodArgumentNotValidException::class)
    fun handleArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ResBaseDto<MutableList<String>>> {
        val errors = mutableListOf<String>()
        exception.bindingResult.fieldErrors.forEach {
            errors.add(it.defaultMessage!!)
        }
        val error = errors[0].split(",")
        val result = ResBaseDto(false, message = "errors", data = null, errors, code = 200)
        return ResponseEntity.badRequest().body(result)
    }
}