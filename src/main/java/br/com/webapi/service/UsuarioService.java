package br.com.webapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webapi.model.Usuario;
import br.com.webapi.respository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario cadastrar(Usuario usuario) {
		return  usuarioRepository.save(usuario);	
	}
	
	public Usuario buscarPorNome(Usuario usuario){
		return usuarioRepository.buscarPorUser(usuario.getNome());
	}
}
