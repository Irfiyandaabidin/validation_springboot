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
    @ExceptionHandler(CustomExceptionHandler::class)
    fun handleCustomException(exception: RuntimeException) : ResponseEntity<Any> {
        val result = ResBaseDto(false, message = "errors", data = null, errors = exception.message)
        return ResponseEntity.badRequest().body(result)
    }

    @ExceptionHandler (MethodArgumentNotValidException::class)
    fun handleArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ResBaseDto<MutableList<String>>> {
        val errors = mutableListOf<String>()
        exception.bindingResult.fieldErrors.forEach {
            errors.add(it.defaultMessage!!)
        }
        val error = errors[0].split(",")
        val result = ResBaseDto(false, message = "errors", data = null, errors)
        return ResponseEntity.badRequest().body(result)
    }
}