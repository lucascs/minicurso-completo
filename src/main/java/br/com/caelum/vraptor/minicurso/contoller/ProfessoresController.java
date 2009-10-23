package br.com.caelum.vraptor.minicurso.contoller;

import static br.com.caelum.vraptor.view.Results.logic;
import static br.com.caelum.vraptor.view.Results.page;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.minicurso.dao.ProfessorDao;
import br.com.caelum.vraptor.minicurso.interceptor.Open;
import br.com.caelum.vraptor.minicurso.model.Professor;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class ProfessoresController {


	private static final Logger logger = Logger.getLogger(ProfessoresController.class);

	private final ProfessorDao dao;

	private final Result result;

	private final Validator validator;

	public ProfessoresController(ProfessorDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Open
	public void form() {
	}

	@Open
	public void adiciona(final Professor professor) {
		validator.checking(new Validations() {{
			if(that(professor.getEmail() != null, "professor.email", "sem.email")) {
				that(professor.getEmail().matches(".+@.*\\..*"), "professor.email", "email.invalido");
			}
		}});
		validator.onErrorUse(page()).of(ProfessoresController.class).form();
		dao.salva(professor);
		logger.debug("professor salvo" + professor);

		result.include("notice", "Professor " + professor.getNome() + " adicionado com sucesso!");
		result.use(logic()).redirectTo(ProfessoresController.class).home();
	}

	public List<Professor> lista() {
		return dao.list();
	}

	public Professor visualiza(Long id) {
		return dao.load(id);
	}
	@Path("/")
	public void home() {

	}
}
