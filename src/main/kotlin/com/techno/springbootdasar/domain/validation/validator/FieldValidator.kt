package com.techno.springboot.dasar.domain.validation.validator

import com.techno.springboot.dasar.domain.validation.CustomFieldValidation
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class FieldValidator: ConstraintValidator<CustomFieldValidation, String> {
    override fun isValid(p0: String?, p1: ConstraintValidatorContext?): Boolean {
        TODO("Not yet implemented")
    }
}