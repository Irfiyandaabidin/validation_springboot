package com.techno.springboot.dasar.domain.validation.validator

import com.techno.springboot.dasar.domain.validation.CustomClassValidation
import java.util.Objects
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ClassValidator:
    ConstraintValidator<CustomClassValidation, Objects>{
    override fun isValid(p0: Objects?, p1: ConstraintValidatorContext?): Boolean {
        TODO("Not yet implemented")
       // val dto = value as RequestDto
    }
}