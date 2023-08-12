package com.techno.springbootdasar.domain.entity

import javax.persistence.*

@Entity
@Table(name = "mahasiswa")
data class MahasiswaEntity(
        @field:Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @field:Column(name = "id", columnDefinition = "bigint")
        val id : Long? = null,

        @field:Column(name = "nim", columnDefinition = "bigint")
        val nim : Long? = null,

        @field:Column(name = "name", columnDefinition = "varchar(100)")
        val name : String? = null,

        @field:Column(name = "gender", columnDefinition = "varchar(100)")
        val gender : String? = null,

        @field:Column(name = "alamat", columnDefinition = "text")
        val alamat : String? = null,

        @ManyToOne
        @field:JoinColumn(name = "id_prodi", referencedColumnName = "uuid" ,columnDefinition = "uuid")
        val idProdi : ProdiEntity? = null
)
