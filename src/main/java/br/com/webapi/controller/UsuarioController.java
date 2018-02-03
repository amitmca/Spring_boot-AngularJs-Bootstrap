package br.com.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.webapi.model.Usuario;
import br.com.webapi.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/usuarios", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.POST)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastrado, HttpStatus.OK);
	}
}
