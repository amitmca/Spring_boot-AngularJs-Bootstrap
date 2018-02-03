package br.com.webapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.webapi.model.Estado;

@Repository
public interface EstadoRespository  extends JpaRepository<Estado, Integer>{

}
