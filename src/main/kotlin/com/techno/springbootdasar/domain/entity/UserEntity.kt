package com.techno.springbootdasar.domain.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
        @field:Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @field:Column(name = "id", columnDefinition = "bigint")
        val id : Long? = null,

        @field:Column(name = "name", columnDefinition = "varchar(100)")
        val name: String? = null,

        @field:Column(name = "username", columnDefinition = "varchar(100)")
        val username: String? = null,

        @field:Column(name = "email", columnDefinition = "varchar(100)")
        val email: String? = null,

        @field:Column(name = "password", columnDefinition = "varchar(100)")
        val password: String? = null
)
