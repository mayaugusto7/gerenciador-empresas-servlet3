package br.com.alura.gerenciador.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Como logout deve ser restrito ao usuario a pagina deve ficar dentro do WEB-INF
 * @author Maycon Ribeiro
 *
 */
public class Logout implements Tarefa {
	
	/*
	 * (non-Javadoc)
	 * @see br.com.alura.gerenciador.web.Tarefa#executa(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		request.getSession().removeAttribute("usuarioLogado");
		
		return "/WEB-INF/paginas/logout.html";
	}
	
}
