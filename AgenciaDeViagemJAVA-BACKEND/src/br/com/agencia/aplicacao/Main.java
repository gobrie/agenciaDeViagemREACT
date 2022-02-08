package br.com.agencia.aplicacao;

import br.com.agencia.dao.UsuarioDAO;

import br.com.agencia.model.Usuario;

public class Main {
	
	public static void main(String[] args) {
		
	 UsuarioDAO usuarioDao = new UsuarioDAO();
	 
	// CRIAR 
	Usuario usuario = new Usuario ();
	usuario.setCpf("12345678912");
	usuario.setNome("Gabriel");
	usuario.setEmail("blabla@homasldn.com");
	usuario.setEndereço("ali");
		
	usuarioDao.save(usuario);

	// UPDATE da classe
		Usuario u1 = new Usuario ();
		u1.setNome("Gabigola");
		u1.setCpf("12345678918");
		u1.setEmail("asdaklsdnasknd");
		u1.setEndereço("aslkdan");
		u1.setIdusuario(1);
		
	// usuarioDao.update(u1);
		
		// DELETAR
		
		usuarioDao.deleteByID(1);
		
		// READ
		
		for (Usuario c : usuarioDao.getUsuarios()) {
			System.out.println("Usuário: " +c.getNome());
		}
	}
}
