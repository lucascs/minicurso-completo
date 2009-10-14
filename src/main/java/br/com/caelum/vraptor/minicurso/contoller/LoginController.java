package br.com.caelum.vraptor.minicurso.contoller;

import static br.com.caelum.vraptor.view.Results.logic;
import static br.com.caelum.vraptor.view.Results.page;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.minicurso.dao.ProfessorDao;
import br.com.caelum.vraptor.minicurso.interceptor.Open;
import br.com.caelum.vraptor.minicurso.model.Professor;
import br.com.caelum.vraptor.minicurso.model.Usuario;
import br.com.caelum.vraptor.validator.Validations;

@Open
@Resource
public class LoginController {

	private final Usuario usuario;
	private final Result result;
	private final Validator validator;
	private final ProfessorDao dao;

	public LoginController(Usuario usuario, ProfessorDao dao, Result result, Validator validator) {
		this.usuario = usuario;
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	public void login(final String email, final String senha) {
		final Professor professor = dao.find(email, senha);
		validator.checking(new Validations() {{
			that(professor != null, "login", "login.invalido");
		}});
		validator.onErrorUse(page()).of(LoginController.class).form();

		usuario.login(professor);

		result.use(logic()).redirectTo(ProfessoresController.class).home();
	}

	public void form() {

	}
}
