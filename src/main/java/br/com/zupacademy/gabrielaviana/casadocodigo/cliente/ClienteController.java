package br.com.zupacademy.gabrielaviana.casadocodigo.cliente;

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
@RequestMapping ("/cliente")
public class ClienteController {
    @Autowired
    private  ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager emt;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest request) {

        Cliente cliente = request.toModel(emt);
        clienteRepository.save(cliente);

        return ResponseEntity.ok(new ClienteResponse(cliente));
    }
}
