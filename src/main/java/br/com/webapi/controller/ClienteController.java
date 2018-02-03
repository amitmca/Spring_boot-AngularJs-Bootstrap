 package br.com.webapi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.webapi.model.Cliente;
import br.com.webapi.service.ClienteService;

@RestController //anotação do controller
@RequestMapping("/admin/*") // mapeia com parte da administração
public class ClienteController {

	@Autowired // injeta a depedencia
	private ClienteService clienteService;

	// mapeia do metodo para ser acessado via requisição
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
		Collection<Cliente> clientesBuscado = clienteService.buscarTodos();

		return new ResponseEntity<>(clientesBuscado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cliente", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> cadrastarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadrastado = clienteService.cadrastar(cliente);

		return new ResponseEntity<Cliente>(clienteCadrastado, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/cliente/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clienteEncontrado = clienteService.procurarPorId(id);

		if (clienteEncontrado == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}

		clienteService.remove(clienteEncontrado);
		return new ResponseEntity<Cliente>(HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/cliente", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente) {

		Cliente clienteAlterado = clienteService.alterar(cliente);

		return new ResponseEntity<Cliente>(clienteAlterado, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cliente/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> buscarPorID(@PathVariable Integer id) {
		Cliente clienteBuscado = clienteService.procurarPorId(id);

		return new ResponseEntity<>(clienteBuscado, HttpStatus.OK);
	}



}
