package br.com.dns.projetoweb.dao;

import org.junit.Test;

import br.com.dns.projetoweb.domain.Testando;

public class TestandoDaoTest {
	
	@Test
	public void salvar() {
		
		Testando testando = new Testando();
		testando.setMatricula("02980888811");
		
		TestandoDao testandoDao = new TestandoDao();
		testandoDao.merge(testando);
	}

}
