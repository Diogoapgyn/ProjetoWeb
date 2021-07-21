package br.com.dns.projetoweb.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dns.projetoweb.domain.Registro;

public class RegistroDaoTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Registro registro = new Registro();
		registro.setCartao(2980888811L);
		registro.setMatricula(50L);
		registro.setPlaca("NKM-8960");
		registro.setEntrada(new SimpleDateFormat("HH:mm:ss").parse("21:28:00"));
		registro.setSaida(new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2022"));

		RegistroDao registroDao = new RegistroDao();
		registroDao.salvar(registro);

	}

	@Test
	public void listar() {
		RegistroDao registroDao = new RegistroDao();
		List<Registro> resultado = registroDao.listar();

		System.out.println("Total de Registros encontrados: " + resultado.size());

		for (Registro registro : resultado) {
			System.out.println(registro.getCodigo() + " - " + registro.getCartao() + " - " + registro.getMatricula());
		}
	}

	@Test
	public void buscar() {
		Long codigo = 2L;

		RegistroDao registroDao = new RegistroDao();
		Registro registro = registroDao.buscar(codigo);

		if (registro == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println(registro.getCodigo() + " - " + registro.getMatricula() + " - " + registro.getCartao());
		}
	}

}
