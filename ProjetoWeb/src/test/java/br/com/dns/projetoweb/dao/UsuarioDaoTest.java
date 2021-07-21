package br.com.dns.projetoweb.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.dns.projetoweb.domain.Usuario;

public class UsuarioDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setSenhaSemCriptografia("123456");

		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());

		usuario.setSenha(hash.toHex());
		usuario.setEmail("sebas@gmail.com");
		usuario.setUser("sebas");
		usuario.setTipo('B');

		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(usuario);

		System.out.println("Usuario salvo com sucesso");
	}

	@Test
	@Ignore
	public void autenticar() {
		String email = "diogosenac86@gmail.com";
		String senha = "123456";

		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.autenticar(email, senha);

		System.out.println("Usuario autenticado: " + usuario.getCodigo());

	}

}
