package br.com.dns.projetoweb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Emprestimo extends GenericDomain {

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 11,nullable = false)
	private String matricula;

	@Column(length = 18, nullable = false)
	private String telefone;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Material material;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrada = new Date();

	@Column(nullable = false)
	private Boolean ativo;

	@Transient
	public String getAtivoFormatado() {
		String ativoFormatado = null;

		if (ativo == true) {
			ativoFormatado = "Sim";
		} else if (ativo == false) {
			ativoFormatado = "Não";
		}
		return ativoFormatado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	
	public String getFormatado() {
		String stringFormatado = null;

		if (matricula != null) {
			stringFormatado = 0 + matricula;
			
		} else if (ativo == false) {
			stringFormatado = "Não";
		}
		return stringFormatado;
	}

}
