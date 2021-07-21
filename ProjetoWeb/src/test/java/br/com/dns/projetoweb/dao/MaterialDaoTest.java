package br.com.dns.projetoweb.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dns.projetoweb.domain.Material;

public class MaterialDaoTest {
	
	@Test
	@Ignore
	public void salvar() {
		Material material = new Material();
		material.setMaterial("Bola de Futebol");
		
		MaterialDao materialDao = new MaterialDao();
		materialDao.merge(material);
		
	}

}
