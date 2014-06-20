package br.com.alura.gerenciador;

import javax.servlet.http.Cookie;

public class Cookies {

	private Cookie[] cookies;
	
	public Cookies(Cookie[] cookies) {
		// TODO Auto-generated constructor stub
		this.cookies = cookies;
	}

	public Cookie getUsuarioLogado() {
		Cookie[] cookies  = this.cookies;
		if(cookies == null) return null;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("usuarioLogado")){
				return cookie;
			}
		}
		return null;
	} 
	
}
