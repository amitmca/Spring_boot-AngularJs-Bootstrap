package br.com.webapi.controller;


import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.webapi.model.Usuario;
import br.com.webapi.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController()
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/autenticar",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException{
		
		 Usuario usuarioAutenticado = usuarioService.buscarPorNome(usuario);
		 
		 if(usuarioAutenticado.getNome()== null){
			 throw new ServletException("Usuario não encontrado");
		 }
		 
		 if (!usuarioAutenticado.getSenha().equals(usuario.getSenha())) {
			 throw new ServletException("Usuario ou senha invalido");
		}
		 
		 String token = Jwts.builder()
				 .setSubject(usuarioAutenticado.getNome())
				 .signWith(SignatureAlgorithm.HS512,"cafe")
				 .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
				 .compact();
		 return new LoginResponse(token);
	}
}

class LoginResponse{
	private String token;
	
	public LoginResponse(String token){
		this.token = token;
	}
	public String getToken() {
		return token;
	}
}
