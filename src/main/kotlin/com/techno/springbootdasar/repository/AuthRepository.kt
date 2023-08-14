package com.techno.springbootdasar.repository

import com.techno.springbootdasar.domain.entity.TokenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AuthRepository : JpaRepository<TokenEntity, String> {
//    fun findById(id: Int) : TokenEntity?
//
//    fun deleteId(id: Int) : Int?
}