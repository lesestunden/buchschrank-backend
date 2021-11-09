package de.aditu.buchschrank.dto

import de.aditu.buchschrank.repository.BookcaseRepository
import org.springframework.stereotype.Component
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [BookcaseExistsValidator::class])
annotation class BookcaseExists(
    val message: String = "",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

@Component
class BookcaseExistsValidator(val bookcaseRepository: BookcaseRepository) :
    ConstraintValidator<BookcaseExists, Long?> {

    override fun isValid(value: Long?, context: ConstraintValidatorContext): Boolean {
        if (value != null && value != 0L && !bookcaseRepository.existsById(value)) {
            context.buildConstraintViolationWithTemplate("BookcaseExists").addConstraintViolation()
            return false
        }

        return true
    }
}