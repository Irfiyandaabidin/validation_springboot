package com.techno.springbootdasar.domain.dto.response

import java.util.UUID

data class ResValidateLoginDto(
        val id : Int? = null,
        val name : String? = null,
        val username : String? = null,
        val email : String? = null,
)
