package br.com.dns.projetoweb.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dns.projetoweb.domain.Emprestimo;
import br.com.dns.projetoweb.domain.Material;

public class EmprestimoDaoTest {
	
	@Test
	public void salvar() throws ParseException {
		
		MaterialDao materialDao = new MaterialDao();	
		Material material = materialDao.buscar(1L);
				
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setMatricula("02980888811");
		emprestimo.setNome("Mateus");
		emprestimo.setTelefone("6235226300");
		emprestimo.setEntrada(new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2022"));
		emprestimo.setAtivo(true);
		emprestimo.setMaterial(material);
		
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		emprestimoDao.merge(emprestimo);
	}
	
	@Test
	@Ignore
	public void listar() {
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		List<Emprestimo> resultado = emprestimoDao.listar();
		
		for(Emprestimo emprestimo : resultado) {
			System.out.println("Matricula: " + emprestimo.getMatricula());
			System.out.println("Nome: " + emprestimo.getNome());
			System.out.println("Telefone: " + emprestimo.getTelefone());
			System.out.println("Entrada: " + emprestimo.getEntrada());
			System.out.println("Pendente: " + emprestimo.getAtivo());
			System.out.println("Matricula: " + emprestimo.getMaterial().getMaterial());
			System.out.println();
		}
	}
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 10L;

		EmprestimoDao emprestimoDao = new EmprestimoDao();
		Emprestimo emprestimo = emprestimoDao.buscar(codigo);
		emprestimoDao.excluir(emprestimo);

	}
	
	

}
