package br.com.webapi.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webapi.model.Estado;
import br.com.webapi.respository.EstadoRespository;

@Service
public class EstadoService  {
	@Autowired
	private EstadoRespository estadoRespository;

	public Collection<Estado> buscarTodos(){
		return estadoRespository.findAll();
	}
	
	
}
