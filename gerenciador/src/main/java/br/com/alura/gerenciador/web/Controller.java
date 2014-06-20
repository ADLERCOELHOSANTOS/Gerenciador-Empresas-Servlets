package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Tarefa;

@WebServlet("/executa")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tarefa = request.getParameter("tarefa");
		if(tarefa == null) throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		try{
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;			
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) type.newInstance();
			String pagina = instancia.adiciona(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
		}catch(ServletException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
			throw new ServletException(e);
		} 
	}

}
