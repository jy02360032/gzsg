package net.webset.util.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import net.webset.util.validator.impl.EnumInTypesValidtor;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumInTypesValidtor.class})
@Documented
public @interface EnumInTypes {
    String message() default "";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    Class<?>[] target() default {};

}
