package com.techno.springbootdasar.domain.dto.request

import javax.validation.constraints.*

data class ReqMahasiswaDto(
        @field:NotNull
        @field:Min(value = 10000, message = "NIM must be greater than or equal to 10000")
        @field:Max(value = 99999, message = "NIM must be less than or equal to 99999")
        val nim : Long? = null,
        @field:NotNull(message = "name must be filled")
        val name : String? = null,

        @field:NotNull(message = "gender must be filled")
        val gender : String? = null,

        @field:NotNull(message = "alamat must be filled")
        val alamat : String? = null,

        @field:NotNull(message = "idProdi must be filled")
        val idProdi : String? = null
)
