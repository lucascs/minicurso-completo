package br.com.caelum.vraptor.minicurso.dao;

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

}
