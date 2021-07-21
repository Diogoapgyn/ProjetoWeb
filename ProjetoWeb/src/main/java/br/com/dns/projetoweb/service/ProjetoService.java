package br.com.dns.projetoweb.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//http:/localhost:8080/ProjetoWeb/rest/[]
@Path("projeto")
public class ProjetoService {
	
	@GET
	public String exibir() {
		return "Curso Java Service";
	}

}
