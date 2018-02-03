package br.com.webapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.webapi.model.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Integer> {

}
