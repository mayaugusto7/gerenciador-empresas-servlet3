package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria2 implements Filter {

	/**
	 * Destroy o filtro
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Parecido com doGet e doPost
	 * Este metodo recebe um request e um response
	 * e os filtros a serem executados uma cadeia de filtros 
	 * 
	 * Queremos utilizar o HttpServletRequest e HttpServletResponse pra isso fazemos um cast
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		
		String usuario = getUsuario(req, res);
		
		System.out.println("Usuario " + usuario + " acessando a URI " + uri);
		
		/**
		 * Tenho que falar pro filtro continuar o processo
		 */
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req, HttpServletResponse res) {
		
		String usuario = "<deslogado>";

		/**
		 * Pega os Cookies do usuario
		 */
		Cookie[] cookies = req.getCookies();

		
		if (cookies == null)
			return usuario;
	
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				
				//postergar o tempo de expiração de um cookie por mais de minutos e adicionar um novo cookie para o usuario
				cookie.setMaxAge(10 * 60);
				res.addCookie(cookie); // reescreve o cookie para o usuario
				
				usuario = cookie.getValue();
			}
		}
		
		return usuario;
	}

	/**
	 * No momento que inicia o filtro
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
