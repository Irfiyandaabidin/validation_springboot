package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResUserDto(
        val id : Int? = null,

        val name: String? = null,

        val username: String? = null,

        val email: String? = null,

)
