package br.com.zupacademy.gabrielaviana.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
		
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid NovoAutorForm form) {
		Autor autor = form.toModel();
		autorRepository.save(autor);		
		
		return ResponseEntity.ok().body(new AutorDto(autor));
	}	
	
}
//O fluxo de criação é form -> autor | autor -> dto
//Dto é o que o cliente vê/recebe de resposta, form o que o cliente preenche/passa os dados e autor é a entidade do sistema ("foto da tabela/banco de dados").
//ResponseEntity é o método do Spring que traz a AutorDto, conforme requisição;
//A requisição feita será validada em AutorDto
//A classe Autor foi instanciada como autor, que será igual a requisição do construtor toModel, que tem os mesmos atributos de Autor.
//O Repository que foi instanciado como autorRepository, pega a requisição e salva como autor, ou seja, a persistência de dados de Autor, será feita em autorRepository.
//Ao ser salvo no repository, a entidade retorna um status 200(ok), informando que o autor foi salvo no repositório e criará uma nova tabela que poderá ser visualizada em NovoAutorForm.
