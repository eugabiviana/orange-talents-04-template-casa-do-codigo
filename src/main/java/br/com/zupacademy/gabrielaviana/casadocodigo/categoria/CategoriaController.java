package br.com.zupacademy.gabrielaviana.casadocodigo.categoria;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping("/categorias")
	@Transactional
	public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid NovaCategoriaForm form) {
		Categoria categoria = form.toModel();
		Optional<Categoria> talvezCategoria = categoriaRepository.findByNome(form.getNome());	
		
		//checagem de nome de categoria existente
//		if(talvezCategoria.isPresent()) {
//			return ResponseEntity.badRequest().build();
//		} virou comentário por causa da @UniqueValue
		
		categoriaRepository.save(categoria);		
		
		return ResponseEntity.ok().body(new CategoriaDto(categoria));
	}	
}
