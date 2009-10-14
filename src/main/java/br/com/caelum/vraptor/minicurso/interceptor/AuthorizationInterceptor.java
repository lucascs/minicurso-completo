package br.com.caelum.vraptor.minicurso.interceptor;

import static br.com.caelum.vraptor.view.Results.logic;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.minicurso.contoller.LoginController;
import br.com.caelum.vraptor.minicurso.model.Usuario;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class AuthorizationInterceptor implements Interceptor {

	private final Usuario usuario;
	private final Result result;

	public AuthorizationInterceptor(Usuario usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}

	public boolean accepts(ResourceMethod method) {
		return !method.getMethod().isAnnotationPresent(Open.class)
			&& !method.getResource().getType().isAnnotationPresent(Open.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance)
			throws InterceptionException {
		if (usuario.getProfessor() == null) {
			result.use(logic()).redirectTo(LoginController.class).form();
		} else {
			stack.next(method, resourceInstance);
		}
	}

}
