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

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

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
		//HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		String usuario = getUsuario(req);
		
		System.out.println("Usuario " + usuario + " acessando a URI " + uri);
		
		/**
		 * Tenho que falar pro filtro continuar o processo
		 */
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		
		String usuarioDeslogado = "<deslogado>";
		
		//Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		
		if (usuario == null)
			return usuarioDeslogado;

		return usuario.getEmail();
	}

	/**
	 * No momento que inicia o filtro
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
