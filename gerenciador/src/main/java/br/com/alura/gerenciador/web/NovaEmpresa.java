package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.Tarefa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/NovaEmpresa")
public class NovaEmpresa implements Tarefa {
	@Override
	public String adiciona(HttpServletRequest request,
			HttpServletResponse response) {
		String nome = request.getParameter("nome");
		Empresa e1 = new Empresa(nome);
		new EmpresaDAO().adiciona(e1);
		request.setAttribute("nome", nome);				
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
}
