package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqUserDto
import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import com.techno.springbootdasar.domain.dto.response.ResUserDto

interface UserService {
    fun getAll() : ResBaseDto<ArrayList<ResUserDto>>
    fun getById(id : Long) : ResBaseDto<ResUserDto>
    fun insert(reqUserDto: ReqUserDto) : ResBaseDto<Any>
    fun update(reqUserDto: ReqUserDto, id : Long) : ResBaseDto<Any>
    fun delete(id: Long) : ResBaseDto<Any>
}