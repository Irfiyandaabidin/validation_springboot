package com.techno.springbootdasar.repository

import com.techno.springbootdasar.domain.entity.MahasiswaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MahasiswaRepository : JpaRepository<MahasiswaEntity, String> {
    fun findByNim(nim: Long) : MahasiswaEntity?
    fun findById(id: Long) : MahasiswaEntity?

    @Query(value = "DELETE MahasiswaEntity WHERE id = :id")
    fun deleteId(id: Long) : Int?
}