package br.com.dns.projetoweb.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/ProjetoWeb/[rest]
@ApplicationPath("rest")
public class ProjetoResourceConfig extends ResourceConfig{
	public ProjetoResourceConfig() {
		packages("br.com.dns.projetoweb.service");
	}
	
}
