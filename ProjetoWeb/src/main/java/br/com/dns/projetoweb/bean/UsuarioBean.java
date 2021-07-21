package br.com.dns.projetoweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Messages;

import br.com.dns.projetoweb.dao.UsuarioDao;
import br.com.dns.projetoweb.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;

	private List<Usuario> usuarios;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@PostConstruct
	public void listar() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarios = usuarioDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os usuÃ¡rios");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			usuario = new Usuario();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo usuÃ¡rio");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			
			SimpleHash hash = new SimpleHash("md5", usuario.getSenha());
			usuario.setSenha(hash.toHex());
			
			usuarioDao.merge(usuario);

			usuario = new Usuario();
			usuarios = usuarioDao.listar();

			Messages.addGlobalInfo("Usuario salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuÃ¡rio");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.excluir(usuario);
			usuarios = usuarioDao.listar();

			// Messages.addGlobalInfo("Matricula: "+registro.getMatricula()+
			// "Cartão:"+registro.getCartao());
			Messages.addGlobalInfo("Removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao excluir!!!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
		Messages.addGlobalInfo("User: " + usuario.getUser()+ "E-Mail:" + usuario.getEmail());
	}

}
