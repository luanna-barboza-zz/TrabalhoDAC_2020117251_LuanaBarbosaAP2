package bean;

import static util.MessageUtil.errorMessage;
import static util.MessageUtil.infoMessage;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.JogoDao;
import entidade.Jogo;

@ManagedBean
public class JogoBean {

	private Jogo jogo = new Jogo();
	private List<Jogo> lista;

	public String salvar() {
		try {
			JogoDao.salvar(jogo);
			infoMessage("Sucesso", "Jogo salvo com sucesso.");
			jogo = new Jogo();
		} catch (Exception e) {
			errorMessage("Erro",
					"Jogo não salvo, se o erro perssistir entre em contato com o administrador do sistema.");
		}
		return null;
	}

	public String editar() {
		try {
			JogoDao.editar(jogo);
			infoMessage("Sucesso", "Jogo editado com sucesso");
			jogo = new Jogo();
		} catch (Exception e) {
			errorMessage("Erro",
					"Jogo não editado, se o erro perssistir entre em contato com o administrador do sistema.");
		}

		return null;
	}

	public String excluir() {
		try {
			JogoDao.excluir(jogo);
			infoMessage("Sucesso", "Jogo excluído com sucesso");
			jogo = new Jogo();
		} catch (Exception e) {
			errorMessage("Erro",
					"Jogo não excluido, se o erro perssistir entre em contato com o administrador do sistema.");
		}
		return null;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getLista() {
		if (lista == null) {
			lista = JogoDao.listarTodos();
		}
		return lista;
	}

	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}
}
