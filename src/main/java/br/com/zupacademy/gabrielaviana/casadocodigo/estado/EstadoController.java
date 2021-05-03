package br.com.zupacademy.gabrielaviana.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid NovoEstadoForm form){
		
		Estado estado = form.toModel(em);
		estadoRepository.save(estado);
		
		return ResponseEntity.ok(new EstadoDto(estado));
	}
}
