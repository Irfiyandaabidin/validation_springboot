package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqUserDto
import com.techno.springbootdasar.domain.dto.response.ResBaseDto
import com.techno.springbootdasar.domain.dto.response.ResUserDto
import com.techno.springbootdasar.service.UserService
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/api/crud")
class UserController (
        private val userService: UserService
) {
    @GetMapping("/user")
    fun getAll(): ResponseEntity<ResBaseDto<ArrayList<ResUserDto>>> {
        val response = userService.getAll()
        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/user")
    fun insert(@Valid @RequestBody reqUserDto: ReqUserDto): ResponseEntity<ResBaseDto<Any>> {
        val response = userService.insert(reqUserDto)
        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/user/{id}")
    fun getById(@PathVariable("id") id : Long): ResponseEntity<ResBaseDto<ResUserDto>> {
        val response = userService.getById(id)
        return ResponseEntity.ok().body(response)
    }

    @PutMapping("/user/{id}")
    fun update(@Valid @PathVariable("id") id : Long, @RequestBody reqUserDto: ReqUserDto): ResponseEntity<ResBaseDto<Any>> {
        val response = userService.update(reqUserDto, id)
        return ResponseEntity.ok().body(response)
    }

    @DeleteMapping("/user/{id}")
    fun delete(@PathVariable("id") id : Long): ResponseEntity<ResBaseDto<Any>> {
        val response = userService.delete(id)
        return ResponseEntity.ok().body(response)
    }
}