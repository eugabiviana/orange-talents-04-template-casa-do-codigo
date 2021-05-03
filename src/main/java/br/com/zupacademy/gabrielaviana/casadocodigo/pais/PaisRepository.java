package br.com.zupacademy.gabrielaviana.casadocodigo.pais;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

	Pais findByNome(String nome);

}
