package br.com.dns.projetoweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.dns.projetoweb.dao.EmprestimoDao;
import br.com.dns.projetoweb.dao.MaterialDao;
import br.com.dns.projetoweb.domain.Emprestimo;
import br.com.dns.projetoweb.domain.Material;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EmprestimoBean implements Serializable {

	private Emprestimo emprestimo;

	private List<Material> materiais;
	private List<Emprestimo> emprestimos;

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}

	@PostConstruct
	public void listar() {
		try {
			EmprestimoDao emprestimoDao = new EmprestimoDao();
			emprestimos = emprestimoDao.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as Emprestimo");
			erro.printStackTrace();
		}
	}
	

	public void novo() {
		try {
			emprestimo = new Emprestimo();

			MaterialDao materialDao = new MaterialDao();
			materiais = materialDao.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova cidade");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {
			EmprestimoDao emprestimoDao = new EmprestimoDao();
			emprestimoDao.merge(emprestimo);

			MaterialDao materialDao = new MaterialDao();
			materiais = materialDao.listar();

			emprestimos = emprestimoDao.listar();
			Messages.addFlashGlobalInfo("Emprestimo salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao gerar um novo emprestimo");
			erro.printStackTrace();
		}

	}

	
	public void stringForm(){
		
	}

	

}
