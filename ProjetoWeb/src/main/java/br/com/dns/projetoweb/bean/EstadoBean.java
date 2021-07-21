package br.com.dns.projetoweb.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.dns.projetoweb.dao.EstadoDao;
import br.com.dns.projetoweb.domain.Estado;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	
	private Estado estado;
	
	//Popular Lista
	private List<Estado> estados;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	@PostConstruct
	public void listar() {
		try {
			EstadoDao estadoDao = new EstadoDao();
			estados = estadoDao.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Listar!!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		 estado = new Estado();
	}
	
	public void salvar() {
		/*
		String texto = "Teste mensagem";
		FacesMessage messagem = new FacesMessage(FacesMessage.SEVERITY_INFO,texto,texto);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, messagem);
		*/
		try {
		EstadoDao estadoDao = new EstadoDao();
		estadoDao.salvar(estado);
		
		//Para limpar depois de salvar,criar nova estancia
		novo();
		
		Messages.addGlobalInfo("Estado salvo com sucesso");
		
		//Forçando erro para aparecer
		//throw new RuntimeException("Erro forçado");
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao salvar!!!");
			erro.printStackTrace();
		}
		
	}

}
