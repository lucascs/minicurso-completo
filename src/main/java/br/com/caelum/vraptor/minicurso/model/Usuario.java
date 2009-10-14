package br.com.caelum.vraptor.minicurso.model;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Usuario {

	private Professor professor;

	public void login(Professor professor) {
		this.professor = professor;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void logout() {
		professor = null;
	}
}
