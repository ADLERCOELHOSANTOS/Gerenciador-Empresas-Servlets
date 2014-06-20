package br.com.alura.gerenciador.web;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Tarefa;

@WebServlet("/Logout")
public class Logout implements Tarefa {

	@Override
	public String adiciona(HttpServletRequest request,
			HttpServletResponse response) {
		
			HttpSession session = request.getSession();
			session.removeAttribute("usuarioLogado");		
			return "/WEB-INF/paginas/logout.html";
	}
}
