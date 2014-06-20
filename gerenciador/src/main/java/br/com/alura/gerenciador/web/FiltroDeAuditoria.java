package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

/**
 * Servlet Filter implementation class FiltroDeAuditoria
 */
@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroDeAuditoria() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String URI = req.getRequestURI();
		chain.doFilter(request, response);
		
		//Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		String usuario = null;
		
		//pegando a session
		HttpSession session = req.getSession();
		if(session.getAttribute("usuarioLogado") == null){
			usuario = "<deslogado>";			
		}else{
			Usuario user = (Usuario) session.getAttribute("usuarioLogado");
			usuario = user.getEmail();
		}
		
		/*if(cookie != null){
			cookie.setMaxAge(60 * 10);
			res.addCookie(cookie);			
			usuario = cookie.getValue();
		}*/
		
		System.out.println("Usuario " + usuario + " acessando a URI " + URI);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
