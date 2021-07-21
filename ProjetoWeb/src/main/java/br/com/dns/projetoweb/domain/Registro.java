package br.com.dns.projetoweb.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Registro extends GenericDomain {

	@Column(nullable = false)
	private Long cartao;
	
	@Column(length = 50, nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private Long matricula;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrada = new Date();
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date saida = new Date();
	
	public Long getCartao() {
		return cartao;
	}
	public void setCartao(Long cartao) {
		this.cartao = cartao;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	
	

}
