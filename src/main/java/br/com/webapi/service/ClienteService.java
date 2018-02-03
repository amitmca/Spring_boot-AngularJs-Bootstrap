package br.com.webapi.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webapi.respository.ClienteRespository;
import br.com.webapi.model.Cliente;

@Service
public class ClienteService {
	@Autowired
	private ClienteRespository clienteRespository;
	
	
	public Collection<Cliente> buscarTodos() {
		return clienteRespository.findAll();
	}

	public  Cliente cadrastar(Cliente cliente) {
		return clienteRespository.save(cliente);
	}

	public void remove(Cliente cliente) {
		clienteRespository.delete(cliente);
	}

	public Cliente procurarPorId(Integer id) {
		return clienteRespository.findOne(id);
	}

	public Cliente alterar(Cliente cliente) {
		return clienteRespository.save(cliente);

	}

}
