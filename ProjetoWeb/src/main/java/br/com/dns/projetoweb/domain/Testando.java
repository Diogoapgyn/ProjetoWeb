package br.com.dns.projetoweb.domain;



import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Testando extends GenericDomain {
	
	@Column(nullable = false,length = 11)
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	


}
