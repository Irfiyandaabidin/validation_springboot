package com.techno.springbootdasar.domain.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.techno.springbootdasar.domain.validation.CustomUniqueValidation
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import kotlin.math.max

data class ReqUserDto(
        @field:NotNull(message = "name is required")
        @field:NotBlank(message = "name notNullRequest cannot be blank")
        @field:Size(max = 100, message = "name value max 100 character")
        @field:Pattern(regexp = "^[a-zA-z]*$", message = "name pattern request must be only string")
        @field:JsonProperty(value = "name")
        val name: String? = null,

        @field:NotNull(message = "username is required")
        @field:CustomUniqueValidation(message = "username is already taken")
        @field:Size(max = 32, message = "username value max 32 character")
        @field:Pattern(regexp = "^(?!\\s*\$).+", message = "username must not contain spaces")
        @field:NotBlank(message = "username notNullRequest cannot be blank ")
        @field:JsonProperty(value = "username")
        val username: String? = null,

        @field:NotNull(message = "email is required")
        @field:CustomUniqueValidation(message = "email is already taken")
        @field:NotBlank(message = "email notNullRequest cannot be blank ")
        @field:Email(message = "email not valid")
        @field:JsonProperty(value = "email")
        val email: String? = null,

        @field:NotNull(message = "password is required")
        @field:Size(max = 32, message = "password value max 32 character")
        @field:NotBlank(message = "password notNullRequest cannot be blank ")
        @field:JsonProperty(value = "password")
        val password: String? = null
)
