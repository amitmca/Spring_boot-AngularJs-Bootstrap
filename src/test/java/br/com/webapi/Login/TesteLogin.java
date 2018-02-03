package br.com.webapi.Login;

import org.junit.Test;

import br.com.webapi.controller.UsuarioController;
import br.com.webapi.model.Usuario;

public class TesteLogin {

	@Test
	public void CadrastaUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome("maria");
		usuario.setSenha("456");
		
		UsuarioController controller = new UsuarioController();
		
		controller.cadastrarUsuario(usuario);
	}
	
}
