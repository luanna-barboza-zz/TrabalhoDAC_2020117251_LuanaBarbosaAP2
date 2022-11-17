package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;

public class JogoDao {
	
	public static Jogo buscarId(int id) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		Jogo jogo = em.find(Jogo.class, id);
		em.close();
		return jogo;
	}

	public static void salvar(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(jogo);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(jogo);
		em.getTransaction().commit();
		em.close();
	}

	public static void excluir(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		jogo = em.find(Jogo.class, jogo.getId());
		em.remove(jogo);
		em.getTransaction().commit();
		em.close();
	}

	public static List<Jogo> listarTodos() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query consulta = em.createQuery("select jogo from Jogo jogo");
		List<Jogo> lista = consulta.getResultList();
		em.close();
		return lista;
	}

}
