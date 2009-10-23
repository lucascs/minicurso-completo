package br.com.caelum.vraptor.minicurso.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.minicurso.model.Professor;

@Component
public class ProfessorDao {

	private final Session session;

	public ProfessorDao(Session session) {
		this.session = session;
	}

	public void salva(Professor professor) {
		session.save(professor);
	}

	public Professor find(String email, String senha) {
		String hql = "from Professor p where p.email = :email and p.senha = :senha";
		return (Professor) session.createQuery(hql)
			.setParameter("email", email)
			.setParameter("senha", senha)
			.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Professor> buscaPorMateria(String materia) {
		String hql = "from Professor p where p.materias like :materia";
		return session.createQuery(hql).setParameter("materia", "%" + materia + "%").list();
	}

	@SuppressWarnings("unchecked")
	public List<Professor> list() {
		return session.createCriteria(Professor.class).list();
	}

	public Professor load(Long id) {
		return (Professor) session.load(Professor.class, id);
	}

}
