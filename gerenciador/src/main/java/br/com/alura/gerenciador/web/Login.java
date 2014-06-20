package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Tarefa;
import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login implements Tarefa {

	@Override
	public String adiciona(HttpServletRequest request,
			HttpServletResponse response) {
		
		String email = request.getParameter("email");
		System.out.println("Aqui " + email);
		String senha = request.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		if (usuario == null || senha == null)
			return "WEB-INF/paginas/erroAutenticacao.jsp";
		else {
			// criando um cookie
			// Cookie cookie = new Cookie("usuario.logado", emailUsr);
			// response.addCookie(cookie);

			// criando uma session
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);			
		}
		return "WEB-INF/paginas/usuarioLogado.jsp";
	}
}
