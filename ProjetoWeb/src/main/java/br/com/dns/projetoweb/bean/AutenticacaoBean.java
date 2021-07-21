package br.com.dns.projetoweb.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.dns.projetoweb.dao.UsuarioDao;
import br.com.dns.projetoweb.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {

	private Usuario usuarioLogado;

	private Usuario usuario;

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	public void autenticar() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();

			usuarioLogado = usuarioDao.autenticar(usuario.getUser(),usuario.getSenha());

			if (usuarioLogado == null) {
				Messages.addGlobalError("Usuario ou senha incorreto !!!");
				return;
			}
			Faces.redirect("./pages/principal.xhtml");
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}

	public boolean temPermissoes(List<String> permissoes) {
		// System.out.println("Permissoes: " +permissoes);
		// return true;

		// Uma permissao por vez da Lista de PERMISSOES
		for (String permissao : permissoes) {
			if (usuarioLogado.getTipo() == permissao.charAt(0)) {
				return true;
			}
		}
		return false;
	}
	
	public String sair() {
		usuarioLogado = null;
		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}

}
