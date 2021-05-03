package br.com.zupacademy.gabrielaviana.casadocodigo.pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	PaisRepository paisRepository;
	
		
	@PostMapping
	@Transactional
	public ResponseEntity<PaisDto> cadastrar (@RequestBody @Valid NovoPaisForm form){
		
		Pais pais = form.toModel();
		paisRepository.save(pais);
		
		return ResponseEntity.ok(new PaisDto(pais));
	}	
}
