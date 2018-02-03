package br.com.webapi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.webapi.model.Estado;
import br.com.webapi.service.EstadoService;

@RestController
public class EstadoController {
	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping(method=RequestMethod.GET, value="/estado",produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Collection<Estado>> buscarEstados(){
		Collection<Estado> estados = estadoService.buscarTodos();
		return new ResponseEntity<>(estados, HttpStatus.OK);
	}
}
