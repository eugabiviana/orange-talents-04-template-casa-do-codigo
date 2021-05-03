package br.com.zupacademy.gabrielaviana.casadocodigo.livro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findById(Long id);

}
