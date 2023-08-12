package com.techno.springbootdasar.repository

import com.techno.springbootdasar.domain.entity.UserEntity
import org.apache.catalina.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<UserEntity, String> {
    fun findById(id: Long) : UserEntity?
    @Query(value = "DELETE UserEntity WHERE id = :id")
    fun deleteId(id: Long) : Int?
}