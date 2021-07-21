package br.com.dns.projetoweb.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.dns.projetoweb.dao.RegistroDao;
import br.com.dns.projetoweb.domain.Registro;
import br.com.dns.projetoweb.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RegistroBean implements Serializable {

	private Registro registro;

	private List<Registro> registros;

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public void listar() {
		try {
			RegistroDao registroDao = new RegistroDao();
			registros = registroDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Listar");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listarOrdenado() {
		try {
			RegistroDao registroDao = new RegistroDao();
			registros = registroDao.listar("entrada");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		registro = new Registro();

	}

	public void selecao() {

	}

	public void salvar() {
		try {
			RegistroDao registroDao = new RegistroDao();
			registroDao.merge(registro);

			novo();
			registros = registroDao.listar("entrada");

			Messages.addGlobalInfo("Salvo com Sucesso !!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao salvar!!!");
			erro.printStackTrace();
		}

	}

	// Actionevent pega coisa que foi capturado na visao XTHML
	// get "f:attribute name -qual nome colocado"
	public void excluir(ActionEvent evento) {
		try {
			registro = (Registro) evento.getComponent().getAttributes().get("registroSelecionado");

			RegistroDao registroDao = new RegistroDao();
			registroDao.excluir(registro);
			registros = registroDao.listar();

			// Messages.addGlobalInfo("Matricula: "+registro.getMatricula()+
			// "Cartão:"+registro.getCartao());
			Messages.addGlobalInfo("Removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao excluir!!!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		registro = (Registro) evento.getComponent().getAttributes().get("registroSelecionado");
		Messages.addGlobalInfo("Matricula: " + registro.getMatricula() + "Cartão:" + registro.getCartao());
	}

	public void imprimir() {
		try {
			String caminho = Faces.getRealPath("/reports/estados.jasper");

			Map<String, Object> parametros = new HashMap<>();

			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);

			JasperPrintManager.printReport(relatorio, true);
		} catch (JRException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatÃ³rio");
			erro.printStackTrace();
		}
	}

}
