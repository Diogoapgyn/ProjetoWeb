package br.com.dns.projetoweb.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.dns.projetoweb.dao.EstadoDao;
import br.com.dns.projetoweb.domain.Estado;

@Path("estado")
public class EstadoService {
	
	@GET
	public String listar(){
		EstadoDao estadoDao = new EstadoDao();
		List<Estado> estados = estadoDao.listar();
		
		Gson gson = new Gson();
		String json = gson.toJson(estados);
		return json;
		
	}

}
