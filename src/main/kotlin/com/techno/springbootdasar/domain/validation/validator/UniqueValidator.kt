package com.techno.springbootdasar.domain.validation.validator

import com.techno.springbootdasar.domain.dto.request.ReqUserDto
import com.techno.springbootdasar.domain.validation.CustomUniqueValidation
import com.techno.springbootdasar.repository.UserRepository
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueValidator(
        private val userRepository: UserRepository
) : ConstraintValidator<CustomUniqueValidation, String>{
    override fun isValid(p0: String?, p1: ConstraintValidatorContext?): Boolean {
        if (p0 == null) {
            return true
        }
        val data = userRepository.findAll()
        data.forEach {
            if(it.username == p0 || it.email == p0)
                return false
        }
        return true
    }
}