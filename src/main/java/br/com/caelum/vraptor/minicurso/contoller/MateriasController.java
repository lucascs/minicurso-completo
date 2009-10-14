package br.com.caelum.vraptor.minicurso.contoller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.minicurso.dao.ProfessorDao;
import br.com.caelum.vraptor.minicurso.model.Professor;

@Resource
public class MateriasController {

	private final ProfessorDao dao;

	public MateriasController(ProfessorDao dao) {
		this.dao = dao;
	}

	public List<Professor> busca(String materia) {
		return this.dao.buscaPorMateria(materia);
	}
}
