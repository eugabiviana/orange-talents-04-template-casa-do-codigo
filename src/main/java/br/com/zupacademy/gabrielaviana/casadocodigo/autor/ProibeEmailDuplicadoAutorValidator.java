//package br.com.zupacademy.gabrielaviana.casadocodigo.autor;
//
//import java.util.Optional;
//import java.util.Set;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validator;
//import javax.validation.executable.ExecutableValidator;
//import javax.validation.metadata.BeanDescriptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//
//@Component
//public class ProibeEmailDuplicadoAutorValidator implements Validator{
//
//	@Autowired
//	private AutorRepository autorRepository;
//	
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return NovoAutorForm.class.isAssignableFrom(clazz);
//	}
//	
//	@Override
//	public void validate(Object target, Errors errors) {
//		if(errors.hasErrors()) {
//			return;
//		}
//
//		NovoAutorForm form = (NovoAutorForm) target;
//		Optional<Autor> possivelAutor = autorRepository.findByEmail(form.getEmail());
//		
//		if(possivelAutor.isPresent()) {
//			errors.rejectValue("email", null, "Email existente! Por favor, insira outro endereço de e-mail." 
//												+ form.getEmail());
//		}
//		
//	}
//	
//}
