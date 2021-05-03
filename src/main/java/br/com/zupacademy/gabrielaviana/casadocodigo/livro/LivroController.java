package br.com.zupacademy.gabrielaviana.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping
	public ResponseEntity<List<Livro>> listar(){
		return ResponseEntity.ok(livroRepository.findAll());
	}
		
	@GetMapping("/{id}") //lógica para detalhar um tópico
	public ResponseEntity<LivroDto> visualizar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		if(livro.isPresent()) {
			return ResponseEntity.ok(new LivroDto(livro.get()));
		}
				
		return ResponseEntity.notFound().build();		
	}
		
}
