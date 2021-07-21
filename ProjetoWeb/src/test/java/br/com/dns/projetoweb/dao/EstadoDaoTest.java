package br.com.dns.projetoweb.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dns.projetoweb.domain.Estado;

public class EstadoDaoTest {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("Rj");

		EstadoDao estadoDao = new EstadoDao();
		estadoDao.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDao estadoDao = new EstadoDao();
		List<Estado> resultado = estadoDao.listar();

		System.out.println("Total de Registros encontrados: " + resultado.size());

		for (Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigo);
		System.out.println("Cod:" + estado.getCodigo() + " " + "Nome:" + estado.getNome());
		estadoDao.excluir(estado);
		System.out.println("Excluido com sucesso: " + estado.getNome());

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 4L;
		EstadoDao estadoDAO = new EstadoDao();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());

			estado.setNome("Santa Catarina");
			estado.setSigla("SC");
			estadoDAO.editar(estado);

			System.out.println("Registro editado - Depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	public void merge(){
		/*
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("Rj");

		EstadoDao estadoDao = new EstadoDao();
	    estadoDao.merge(estado);
	    */
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(5L);
		estado.setSigla("RJ");
		estadoDao.merge(estado);
		
	}
	
	
	

}
