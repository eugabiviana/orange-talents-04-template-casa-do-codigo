package br.com.zupacademy.gabrielaviana.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroRepository livroRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoLivroForm form) {
		Livro livro = form.toModel(em);			
//		livroRepository.save(livro);		
//		
//		return ResponseEntity.ok().body(new LivroDto(livro));
		
		em.persist(livro);

        return livro.toString();
	}	
}
