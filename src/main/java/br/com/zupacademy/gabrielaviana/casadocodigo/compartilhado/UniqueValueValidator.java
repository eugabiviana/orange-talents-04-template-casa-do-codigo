package br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements  ConstraintValidator<UniqueValue, Object>{

	private String domainAttibute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public void initialize(UniqueValue params) {
		domainAttibute = params.fieldName();
		klass = params.domainClass();
	}
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttibute+"=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.isTrue(list.size() <=1, "Foi encontrado mais de um "+klass+" com o atributo "+domainAttibute+"= "+value);
		
		return list.isEmpty();
	}
		
}

//esse código pode ser usado em qualquer projeto!