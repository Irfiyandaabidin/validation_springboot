package com.techno.springbootdasar.service.impl

import at.favre.lib.crypto.bcrypt.BCrypt
import com.techno.springbootdasar.domain.dto.request.ReqUserDto
import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import com.techno.springbootdasar.domain.dto.response.ResMahasiswaDto
import com.techno.springbootdasar.domain.dto.response.ResUserDto
import com.techno.springbootdasar.domain.entity.UserEntity
import com.techno.springbootdasar.repository.UserRepository
import com.techno.springbootdasar.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class UserServiceImpl (
        private val userRepository: UserRepository
) : UserService {
    override fun getAll(): ResBaseDto<ArrayList<ResUserDto>> {
        val data = userRepository.findAll()
        if(data.isEmpty())
            return ResBaseDto(false, "Data not found", null)
        val response : ArrayList<ResUserDto> = ArrayList()
        data.forEach {
            response.add(
                    ResUserDto(
                            name = it.name!!,
                            username = it.username!!,
                            email = it.email!!,
                    )
            )
        }
        return ResBaseDto(data = response)
    }

    override fun getById(id: Long): ResBaseDto<ResUserDto> {
        val data = userRepository.findById(id)
        if(data == null)
            return ResBaseDto(false, "Data not found", null)
        val response = ResUserDto(
                name = data.name!!,
                username = data.username!!,
                email = data.email!!
        )
        return ResBaseDto(data = response)
    }

    override fun insert(reqUserDto: ReqUserDto): ResBaseDto<Any> {
        val hashPassword = BCrypt.withDefaults().hashToString(10, reqUserDto.password!!.toCharArray())
        val data = UserEntity(
                name = reqUserDto.name,
                username = reqUserDto.username,
                email = reqUserDto.email,
                password = hashPassword
        )
        val entity = userRepository.save(data)
        val response = ResUserDto(
                name = entity.name!!,
                username = entity.username!!,
                email = entity.email!!
        )
        return ResBaseDto(data = response)
    }

    override fun update(reqUserDto: ReqUserDto, id: Long): ResBaseDto<Any> {
        val data = userRepository.findById(id) ?: return ResBaseDto(false, "Data not found", null)
        val hashPassword = BCrypt.withDefaults().hashToString(10, reqUserDto.password!!.toCharArray())
        val newData = data.copy(
                name = reqUserDto.name,
                username = reqUserDto.username,
                email = reqUserDto.email,
                password = hashPassword
        )
        val entity = userRepository.save(newData)
        val response = ResUserDto(
                name =  entity.name!!,
                username = entity.username!!,
                email = entity.email!!
        )
        return ResBaseDto(data = response)
    }

    override fun delete(id: Long): ResBaseDto<Any> {
        val data = userRepository.findById(id) ?: return ResBaseDto(false, "Data not found", null)
        val entity = userRepository.delete(data)
        return ResBaseDto(data = null)
    }
}