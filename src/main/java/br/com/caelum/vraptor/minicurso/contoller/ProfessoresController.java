package br.com.caelum.vraptor.minicurso.contoller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.minicurso.dao.ProfessorDao;
import br.com.caelum.vraptor.minicurso.interceptor.Open;
import br.com.caelum.vraptor.minicurso.model.Professor;

@Resource
public class ProfessoresController {

	private final ProfessorDao dao;

	public ProfessoresController(ProfessorDao dao) {
		this.dao = dao;
	}

	@Open
	public void form() {
	}

	public void adiciona(Professor professor) {
		dao.salva(professor);
	}

	@Path("/")
	public void home() {

	}
}
