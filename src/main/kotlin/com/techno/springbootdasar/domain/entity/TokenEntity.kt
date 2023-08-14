package com.techno.springbootdasar.domain.entity

import java.time.LocalDateTime
import java.util.Date
import java.util.UUID
import javax.annotation.processing.Generated
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "token_user")
data class TokenEntity(
        @field:Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @field:Column(name = "id", columnDefinition = "bigint")
        val id : Int? = null,

        @field:Column(name = "token", columnDefinition = "varchar")
        val token : String? = null,

        @field:Column(name = "expired", columnDefinition = "timestamp")
        val expired : LocalDateTime? = null,

        @ManyToOne
        @field:JoinColumn(name = "id_user", referencedColumnName = "id", columnDefinition = "bigint")
        val idUser : UserEntity? = null,
)
