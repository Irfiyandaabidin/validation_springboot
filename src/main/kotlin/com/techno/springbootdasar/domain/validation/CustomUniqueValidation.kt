package com.techno.springbootdasar.domain.validation

import com.techno.springbootdasar.domain.validation.validator.UniqueValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UniqueValidator::class])
annotation class CustomUniqueValidation(
        val message: String = "",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
)
