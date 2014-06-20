package br.com.alura.gerenciador.web;


import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.Tarefa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet("/BuscaEmpresa")
public class BuscaEmpresa implements Tarefa {
	
    public BuscaEmpresa() {
        System.out.println("Instanciando uma Tarefa do tipo BuscaEmpresa "
                + this);
    }	

	@Override
	public String adiciona(HttpServletRequest request,
			HttpServletResponse response) {
		
		String filtro = request.getParameter("filtro");
		EmpresaDAO empresa = new EmpresaDAO();
		Collection<Empresa> empresas = empresa.buscaPorSimilaridade(filtro);
		request.setAttribute("empresas", empresas);
		return "WEB-INF/paginas/buscaEmpresa.jsp";
	}
}
