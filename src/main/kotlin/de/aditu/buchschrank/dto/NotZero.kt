package de.aditu.buchschrank.dto

import org.springframework.stereotype.Component
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NotZeroValidator::class])
annotation class NotZero(
    val message: String = "",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

@Component
class NotZeroValidator() :
    ConstraintValidator<NotZero, Double> {

    override fun isValid(value: Double, context: ConstraintValidatorContext): Boolean {
        if (value == 0.0) {
            context.buildConstraintViolationWithTemplate("notZero").addConstraintViolation()
            return false
        }

        return true
    }
}