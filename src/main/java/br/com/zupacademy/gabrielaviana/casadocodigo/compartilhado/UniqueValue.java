package br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

	//padrão se falha
	String message() default "{br.com.zupacademy.beanvalidation.unique}";
	
	//validação para grupos específicos (ex.:adm, não admin etc.)
	Class<?>[] groups() default {};
	
	//informação a mais
	Class<? extends Payload>[] payload() default {};
	
	String fieldName();
	Class<?> domainClass();
}


//esse código pode ser usado em qualquer projeto!